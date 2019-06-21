##############################################################
##
##      Copyright (2019, ) Institute of Software
##          Chinese Academy of Sciences
##             Author: wuheng@otcaix.iscas.ac.cn
##
################################################################


if [ ! -d "/home/virtctl/bin/virtctl.py" ];then
  cp /home/virtctl/virtctl.py /home/virtctl/bin/virtctl.py
fi

python /home/virtctl/bin/virtctl.py
