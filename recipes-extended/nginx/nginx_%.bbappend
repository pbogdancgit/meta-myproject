FILESEXTRAPATHS:prepend := "${THISDIR}:"

SRC_URI += "file://nginx.conf"
do_install:append() {
    install -d ${D}${sysconfdir}/nginx
    install -m 0644 ${WORKDIR}/nginx.conf ${D}${sysconfdir}/nginx/nginx.conf

    install -d ${D}/var/www/html
    echo "Hello from Yocto nginx" > ${D}/var/www/html/index.html
}

SYSTEMD_AUTO_ENABLE:${PN} = "enable"