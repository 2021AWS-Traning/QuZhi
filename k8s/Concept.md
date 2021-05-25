## Pod
- smallest
- most basic
- deployable resource
- Pods have one or more containers, such as Docker containers.
- Each pod have a different ip.

## Deployment
- Deployments represent a many same Pods cause they use a same `deployment.yaml`.
- A Deployment runs multiple replicas of your application, controlled by replica param.
- After modified, use `kubectl apply` to update it. If more replicas, extra resource will be killed.

## Node
- A Pod always runs on a Node.

## Service
- An abstract architecture to expose an application-cluster which have many Pods to public service.
- Four ways to do this, `ClusterIP`, `NodePort`, `LoadBalancer`, and `Ingress`.

## Ingress
- Kubernetes Ingress is an API object that provides routing rules to manage external users' access to the services in a Kubernetes cluster.
- With Ingress, we can easily set up rules for routing traffic without creating a bunch of Load Balancers or exposing each service on the node.

## ReplicaSet
- Improve high-availability for pods.
- If a pod is crashed, RS will auto-create another new pod to replace the elder one.
- `selector`: Determines what kind of pod RS will manage.
- `replicas`: Obviously, number of replicas.

Namespace
- Abstract way to organize clusters into virtual sub-clusters
- When people work across many teams or projects. It will be helpful to `share a Kubernetes cluster`.
