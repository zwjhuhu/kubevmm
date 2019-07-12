'''
Copyright (2019, ) Institute of Software, Chinese Academy of Sciences

@author: wuyuewen@otcaix.iscas.ac.cn
@author: wuheng@otcaix.iscas.ac.cn

https://pypi.org/project/json2xml/
https://github.com/kubernetes/kubernetes/issues/51046
'''

from utils import runCmd

def get_block_dev_json(block):
    return runCmd('/usr/bin/qucil %s' % block)

def is_block_dev_exists(block):
    return runCmd('lvdisplay | grep %s' % block)