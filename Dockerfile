# FROM openjdk:11
FROM eclipse-temurin:17

WORKDIR /code
COPY . /code

RUN chmod +x run.sh

RUN apt-get update; \ 
    apt-get -y install maven \
    dos2unix \
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

CMD [ "./run.sh" ]
