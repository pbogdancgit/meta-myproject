inherit core-image

DESCRIPTION = "Custom image with nginx and mychardev interface"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Am unit toate pachetele intr-o singura linie curata
IMAGE_INSTALL:append = " nginx init-iface systemd systemd-analyze systemd-serialgetty"

SYSTEMD_AUTO_ENABLE = "enable"


