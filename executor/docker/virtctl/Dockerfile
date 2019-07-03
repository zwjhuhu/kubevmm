FROM centos:7

RUN mkdir -p /home/virtctl/bin

ADD virtctl.py /home/virtctl/bin

ADD virtctl.sh /home/virtctl/bin

ADD default.cfg /home/virtctl/bin

ADD libvirt_util.py /home/virtlet/bin

RUN yum install epel-release -y

RUN yum install virt-manager python2-devel python2-pip libvirt-devel gcc gcc-c++ glib-devel glibc-devel -y

RUN pip install --upgrade pip

RUN pip install --ignore-installed kubernetes libvirt-python xmljson xmltodict

WORKDIR /home/virtctl/bin

RUN bash virtctl.sh
