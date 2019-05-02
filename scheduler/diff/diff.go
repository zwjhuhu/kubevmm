/************************************************************************************
 *
 *                        Model free architecture
 *
 *   author: wuheng@otcaix.iscas.ac.cn
 *   author: xianghao16@otcaix.iscas.ac.cn
 *   author: yangchen18@otcaix.iscas.ac.cn
 ************************************************************************************/


func NewCRDClient() (dynamic.Interface, error) {
	bytes, _ := ioutil.ReadFile("/etc/kubernetes/admin.conf")
	config, _ := clientcmd.NewClientConfigFromBytes(bytes)
	clientConfig, _ := config.ClientConfig()
	return dynamic.NewForConfig(clientConfig)
}

// we would consider some exceptions later
func SupportCRD(suggestedHost string, pod *v1.Pod, coreClient clientset.Interface, crdClient dynamic.Interface) {

	var gvr = schema.GroupVersionResource {
		Group:    pod.GetAnnotations()["crdGroup"],
		Version:  pod.GetAnnotations()["crdVersion"],
		Resource: pod.GetAnnotations()["crdKind"],
	}

	// get spec.nodeName
	host := fmt.Sprintf(`{"spec":{"nodeName":"%s"}}`, suggestedHost)

	// bind resource
	crdClient.Resource(gvr).Namespace(pod.GetAnnotations()["crdNamespace"]).
		Patch(pod.GetAnnotations()["crdName"], types.MergePatchType, []byte(host), metav1.PatchOptions{})

	// delete this pod
	coreClient.CoreV1().Pods("default").Delete(pod.GetName(), &metav1.DeleteOptions{})

}

