# harness-lab-app

A small Spring Boot app for the Harness Enterprise SE candidate lab.

- `GET /?name=X` returns a greeting, the app version, and the pod name (handy for watching a canary rollout).
- `GET /actuator/health` is used for Kubernetes probes.

Harness CI builds and tests it with Maven, then builds and pushes `pratsjuneja/harness-lab-app` to Docker Hub.
