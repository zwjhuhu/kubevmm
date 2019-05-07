
## Step 1: pack

```
mvn clean install
```

## Step 2: build

```
cp targets/kubevirt-controller-2.0.0-SNAPSHOT-jar-with-dependencies.jar docker/
docker build docker/ -t kubesys.github.io/kubevirt-controller-manager:v1.14.1
```
