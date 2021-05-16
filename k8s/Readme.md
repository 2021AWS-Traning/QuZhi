## Deploy java project on kubernetes.
### execute `kubectl cluster-info` to ensure cluster work.
- Docker-Desktop
- ...

### run `kubectl get all` to ensure.

### build image and push image to docker hub.

## Here, we combine `deployment.yaml and service.yaml` to a new yaml.

### `kubectl create deployment demo --image=springguides/demo --dry-run=client -o=yaml > deployment.yaml`
- `--image`: image name.

### `echo --- >> deployment.yaml`

### `kubectl create service clusterip demo --tcp=8080:8080 --dry-run -o=yaml >> deployment.yaml`
### `clusterip` is a vip which can route to many pods., `nodeport` can only mapping to one pod port.

### Run `kubectl apply -f deployment.yaml` to start.
- The difference from `apply` and `create` is: `create` is creating new deployment. `apply` is using new `deployment.yaml` to update it.
- Use `kubectl delete deployment name`. Then pod will be deleted.
- If using `kubectl delete pod name`. Then pod will be redeploy a new one.
- Use `kubectl delete svc name`.
- Use `kubectl delete pod,svc name`. Both delete.

### Run `kubectl get all` until deployment is running. 
- Use `kubectl get pod`
- Use `kubectl get node`
- Use `kubectl get deployment`
- Use `kubectl get svc`

### Run `kubectl port-forward svc/demo 8080:8080` to expose 8080.
### Then we can access 8080 to access service, then pod.

### Run `curl localhost:8080/actuator/health` to confirm everything works.


## Expose Service
- `port-forward` mapping port to internal service.
- `NodePort` much more official than `port-forward`. Use `Service` to do this.
- `ingress` I got a question not solved: After I run `kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.46.0/deploy/static/provider/cloud/deploy.yaml`. It doesn't work. 
  When run `kubectl get pods -n ingress-nginx -l app.kubernetes.io/name=ingress-nginx --watch`. Deployment is not successful.
  From [k8s-ingress-controller](https://kubernetes.github.io/ingress-nginx/deploy/#verify-installation)

## Command
- `kubectl logs` used to read log and export log.
- `kubectl describe` show details.
- `kubectl apply` use yaml to deploy deployment or service.
- `kubectl delete` delete pod,deployment,service...
