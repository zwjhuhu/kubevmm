```
apiVersion: v1
kind: VirtualMachine
metadata:
  name: kube100-site
  labels:
    app: web
spec:
  domain:
  '_type': string
  '_id': string
  name: string
  uuid: string
  genid: string
  title: string
  description: string
  metadata: null
  maxMemory:
    '_unit': string
    '_slots': string
    'text': string
  memory:
    '_unit': string
    '_dumpCore': string
    'text': string
  currentMemory:
    '_unit': string
    'text': string
  blkiotune:
    weight: string
    device:
    - path: string
      weight: string
      read_iops_sec: string
      write_iops_sec: string
      read_bytes_sec: string
      write_bytes_sec: string
    - path: string
      weight: string
      read_iops_sec: string
      write_iops_sec: string
      read_bytes_sec: string
      write_bytes_sec: string
  memtune:
    hard_limit:
      '_unit': string
      'text': string
    soft_limit:
      '_unit': string
      'text': string
    min_guarantee:
      '_unit': string
      'text': string
    swap_hard_limit:
      '_unit': string
      'text': string
```
