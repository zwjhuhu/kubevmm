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
from json import loads
from xmljson import badgerfish as bf
import os


INPUT    = "../../analyser/files/"
OUTPUT   = "docs/"

def xmlToYaml(xmlstr):
    return obj_to_yaml(parse(xmlstr))

def yamlToXml(yamlstr):
    yaml = yamlstr.replace('_interface', 'interface').replace(
        '_', '@').replace('text', '#text').replace('\'', '"')
    return unparse(obj_from_yaml(yaml))

def xmlToJson(xmlStr):
    return bf.etree(xmlStr)

def jsontoxml(jsonstr):
    json = jsonstr.replace('_interface', 'interface').replace(
        '_', '@').replace('text', '#text').replace('\'', '"')
    return unparse(loads(json))

def readXml(name):
    xmlstr = ""
    file = open(INPUT + name)
    for line in file:
        xmlstr = xmlstr + line
    file.close()
    return xmlstr

def xmlStyle(INPUT):
    for name in os.listdir(INPUT):
        print("## " + name)
        print("\n```")
        print(readXml(name))
        print("```\n")
        
def yamlStyle(INPUT):
    for name in os.listdir(INPUT):
        print("## " + name.replace("xml", "yaml"))
        print("\n```")
        print(xmlToYaml(readXml(name)).decode().replace(
            '@', '_').replace('interface', '_interface').replace('#text', 'text'))
        print("```\n")
        
def jsonStyle(INPUT):
    for name in os.listdir(INPUT):
        print("## " + name.replace("xml", "json"))
        print("\n```")
        print(xmlToJson(readXml(name)).decode().replace(
            '@', '_').replace('interface', '_interface').replace('#text', 'text'))
        print("```\n")

if __name__ == '__main__':
    yamlStyle(INPUT)