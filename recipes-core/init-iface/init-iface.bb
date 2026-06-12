DESCRIPTION = "Bring up eth0 automatically"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Schimbăm sursa de la scriptul de shell la fișierul nostru .c
SRC_URI = "file://init-iface.c"

S = "${WORKDIR}"

# Adăugăm sarcina de compilare pentru codul C
do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} init-iface.c -o init-iface
}

# Modificăm do_install pentru a pune binarul în /usr/bin/ în loc de /etc/init.d/
do_install() {
    install -d ${D}${bindir}
    install -m 0755 init-iface ${D}${bindir}/init-iface
}

# --- AM COMENTAT TOATĂ LOGICA DE SYSVINIT DE MAI JOS ---
# inherit update-rc.d
# INITSCRIPT_NAME = "init-iface"
# INITSCRIPT_PARAMS = "start 20 S ."
