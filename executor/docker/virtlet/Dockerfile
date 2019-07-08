FROM centos:7

RUN mkdir -p /home/virtlet/bin

ADD virtlet.py /home/virtlet/bin

ADD virtlet.sh /home/virtlet/bin

ADD utils /home/virtlet/bin

ADD default.cfg /home/virtlet/bin

RUN yum install epel-release -y

RUN yum install virt-manager python2-devel python2-pip libvirt-devel gcc gcc-c++ glib-devel glibc-devel -y

RUN pip install --upgrade pip

RUN pip install --ignore-installed kubernetes libvirt-python xmljson xmltodict

RUN yum clean all

RUN rm -fr /tmp/*

WORKDIR /home/virtlet/bin

RUN bash virtlet.sh
