############################################
##
## Copyright (2019, ) Institute of Software
##        Chinese Academy of Sciences
##         Author: wuheng@otcaix.iscas.ac.cn
##           Date: 2019-06-17
##
############################################

cmds=$(virsh help | egrep -v "cd|echo|exit|help|pwd|quit|connect" | egrep -v "list|event|allocpages|capabilities|cpu-baseline|cpu-compare|cpu-models|domcapabilities|freecell|freepages|hostname|hypervisor-cpu-baseline|hypervisor-cpu-compare|maxvcpus|node-memory-tune|nodecpumap|nodecpustats|nodeinfo|nodememstats|nodesuspend|sysinfo|uri|iface-begin|iface-commit|iface-rollback|version|domstats" | grep -v "Grouped" |grep -Ev "^$|[#;]" | awk '{print$1}')

rm -rf params

for cmd in $cmds
do
  echo "["$cmd"]" >> params
  virsh $cmd --help | grep -A 20 "OPTIONS" | grep -v "OPTIONS" | awk '{gsub(/^\s+|\s+$/, "");print}' >> params
done
