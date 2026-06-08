inherit core-image

DESCRIPTION = "Custom image with nginx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
IMAGE_INSTALL:append = " nginx"
IMAGE_INSTALL:append = " init-iface"
SYSTEMD_AUTO_ENABLE = "enable"
IMAGE_INSTALL:append = " systemd systemd-analyze systemd-serialgetty"