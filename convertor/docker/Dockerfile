FROM openjdk:8u201-jdk-alpine3.9

RUN mkdir -p /home/kubevirt-controller-manager
RUN mkdir -p /etc/kubernetes/

ADD kubevirt-convertor-2.0.0-SNAPSHOT-jar-with-dependencies.jar /home/kubevirt-controller-manager

WORKDIR /home/kubevirt-controller-manager

RUN java -jar kubevirt-convertor-2.0.0-SNAPSHOT-jar-with-dependencies.jar
