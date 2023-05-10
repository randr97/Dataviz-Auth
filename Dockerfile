# FROM openjdk:11
FROM eclipse-temurin:17

WORKDIR /code
COPY . /code

RUN apt-get update; \ 
    apt-get -y install maven \
    wget \
    pkg-config \
    build-essential \
    cmake \
    autoconf \
    libtool \
    zlib1g-dev \
    lsb-release \
    swig \
    && apt-get autoremove -yqq --purge \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*
