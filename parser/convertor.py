'''
COpyright (2019, ) Institute of Software, Chinese Academy of Sciences

Created on Apr 28, 2019

@author: wuheng@otcaix.iscas.ac.cn

https://github.com/guillon/xmlplain
https://github.com/martinblech/xmltodict
'''

from xmlplain import obj_from_yaml
from xmlplain import obj_to_yaml
from xmltodict import parse
from xmltodict import unparse

xmlStr  = '<domain id="int"><genid>value</genid></domain>'

def xmlToYaml(xml):
    return obj_to_yaml(parse(xml))

def yamlToXml(yaml):
    return unparse(obj_from_yaml(yaml))

if __name__ == '__main__':
    yaml = xmlToYaml(xmlStr).decode()
    print(yamlToXml(yaml))