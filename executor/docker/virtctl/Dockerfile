FROM centos:7

RUN mkdir -p /home/virtctl/bin

ADD virtctl.py /home/virtctl/bin

ADD virtctl.sh /home/virtctl/bin

RUN yum install epel-release -y

RUN yum install python2-devel python2-pip libvirt-devel gcc gcc-c++ glib-devel glibc-devel -y

RUN pip install --upgrade pip

RUN pip install --ignore-installed kubernetes libvirt-python xmljson

WORKDIR /home/virtctl/bin

RUN bash virtctl.sh
