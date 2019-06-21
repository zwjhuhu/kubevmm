FROM centos:7

RUN mkdir -p /home/virtctl/bin

ADD virtctl.py /home/virtctl

RUN yum install epel-release -y

RUN yum install python2-pip -y

RUN pip install --upgrade pip

RUN pip install kubernetes libvirt-python xmljson

WORKDIR /home/virtctl/bin

RUN bash virtctl.sh
