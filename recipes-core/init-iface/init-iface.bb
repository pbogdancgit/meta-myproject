DESCRIPTION = "Bring up eth0 automatically"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://init-iface"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${S}/init-iface ${D}${sysconfdir}/init.d/init-iface
}

inherit update-rc.d
INITSCRIPT_NAME = "init-iface"
INITSCRIPT_PARAMS = "start 20 S ."