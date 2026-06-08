SUMMARY = "Bogdan's char driver with Device Tree"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit module

SRC_URI = "file://chardriver.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} -c ${WORKDIR}/chardriver.c -o chardriver.o
    ${LD} -r -o chardriver.ko chardriver.o
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra
    install -m 0644 chardriver.ko ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/
}

FILES:${PN} += "${nonarch_base_libdir}/modules/${KERNEL_VERSION}/extra/chardriver.ko"
