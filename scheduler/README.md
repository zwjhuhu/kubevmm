# Scheduler

Queue-oriented, Model-free Kubernetes's scheduler for Various Application Lifecycle Management


# Prerequisite

Ensure you have configured GOROOT and GOPATH

- IDE: GoLand 
- Go: >= 1.10.3
- go get -u -v k8s.io/client-go
- go get -u -v k8s.io/kubernetes

# Deploy Steps
#### Step 1: Add code to kube-scheduler source code
Find `$GOPATH/k8s.io/kubernetes/pkg/scheduler/scheduler.go`, namely original `scheduler.go`.
Find `$GOPATH/k8s.io/kubernetes/pkg/scheduler/factory/factory.go`, namely original `factory.go`.

##### Method1:
Copy all the code snippets in file `<RepoPath>/diff.go` to the end of `scheduler.go`, resolve all the import and package problems, then find `func (sched *Scheduler) Run()` in original `scheduler.go`(around line 281), change it as shown below.

find `func(sched *Scheduler) scheduleOne()` in original `scheduler.go`, insert several lines of code behind `suggestedHost, err := sched.schedule(pod)`
(around line 540). After the insertion, `func(sched *Scheduler) scheduleOne()` should look like this:

```go
func (sched *Scheduler) scheduleOne() {
	[...]
	start := time.Now()
	scheduleResult, err := sched.schedule(pod)
	if err != nil {

		//--------------------------------------
		//          Support CRD
		//-------------------------------------
		if pod.GetAnnotations()["crdKind"] != "" {
			SupportCRD(scheduleResult.SuggestedHost,
				pod, sched.config.CoreClient, sched.config.CRDClient)
			return
		}
                //--------------------------------------
		//          Support CRD
		//-------------------------------------
                
		// schedule() may have failed because the pod would not fit on any host, so we try to
		// preempt, with the expectation that the next time the pod is tried for scheduling it
		// will fit due to the preemption. It is also possible that a different pod will schedule
		// into the resources that were preempted, but this is harmless.

		if fitError, ok := err.(*core.FitError); ok {
			if !util.PodPriorityEnabled() || sched.config.DisablePreemption {
				klog.V(3).Infof("Pod priority feature is not enabled or preemption is disabled by scheduler configuration." +
					" No preemption is performed.")
			} else {
	   
```

##### Method2:
Just replace the original `scheduler.go` with `<RepoPath>/kube/scheduler.go`, and 'factory.go' with `<RepoPath>/kube/factoy/factory.go`

#### Step 2: Rebuild scheduler
Move to `$GOPATH/k8s.io/kubernetes/cmd/kube-scheduler/`, and build with command `env GOOS=linux GOARCH=amd64 go build scheduler.go`, now you get a executable binary file `scheduler`.
#### Step 3: Pack as a image
Build the image with `<RepoPath>/build/Dockerfile`, before that you need to move executable scheduler binary file to /build path, then build image with command.

```
docker build -t custom-scheduler:1.0 .
```
#### Step 4: Deploy
Created a Deployment configuration file and ran it in an existing Kubernetes cluster, using the Deployment resource rather than creating a Pod resource directly because the Deployment resource can better handle the case of a scheduler running node failure. We offered a Deployment configuration example, saved as the `custom-scheduler.yaml` in `<RepoPath>/yaml/`.

Then Create Deployment resource in Kubernetes cluster

```
kubectl create -f custom-scheduler.yaml
```

# Try it out

