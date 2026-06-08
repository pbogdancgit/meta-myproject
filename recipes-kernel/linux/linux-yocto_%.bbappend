FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Kernel patches and configs
SRC_URI += "file://mychardev.cfg"
SRC_URI += "file://0001-Add-mychar-driver.patch"

# DTS + DTC include
SRC_URI += "file://qemutst.dts"
SRC_URI += "file://mychardev.dtsi"

# Tell Yocto to expect a flat DTB binary in the main output folder
KERNEL_DEVICETREE:qemuarm64 += "qemutst.dtb"

# Modify kernel sources before compilation
do_configure:append:qemuarm64() {
    # Copy files directly to the root arm64 dts folder
    cp ${WORKDIR}/mychardev.dtsi ${S}/arch/arm64/boot/dts/
    cp ${WORKDIR}/qemutst.dts ${S}/arch/arm64/boot/dts/

    # Inject the include into the DTS file if it isn't there
    if ! grep -q "mychardev.dtsi" ${S}/arch/arm64/boot/dts/qemutst.dts; then
        echo '#include "mychardev.dtsi"' >> ${S}/arch/arm64/boot/dts/qemutst.dts
    fi

    # Directly force Kbuild to recognize the flat DTB in the main Makefile
    if ! grep -q "qemutst.dtb" ${S}/arch/arm64/boot/dts/Makefile; then
        echo "dtb-y += qemutst.dtb" >> ${S}/arch/arm64/boot/dts/Makefile
    fi
}
