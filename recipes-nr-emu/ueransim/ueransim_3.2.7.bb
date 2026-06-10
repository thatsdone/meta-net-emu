SUMMARY = "UERANSIM"
DESCRIPTION = "Yocto Recipe for UERANSIM nr-ue and nr-cli"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-or-later;md5=1c76c4cc354acaac30ed4d5eefea7245"

SRC_URI = "git://github.com/aligungr/UERANSIM.git;protocol=https;branch=master"
# v3.2.7 (latest as of June 30, 2025)
SRCREV_default = "1d1e154f869260b5e98f6905827b1bd9b8663afc"
# v3.3.0 (latest as of Jun 7, 2026)
#SRCREV_default = "6bf5a1a96aaef6ae8778b9d8b477ac6e2bbf8156"

# patch required for Wrynose (GCC 15), but compatible with Scarthgap (GCC 13)
SRC_URI += "file://0001-yaml-cpp-add-missing-cstdint-include.patch"

python () {
    release = d.getVar('LAYERSERIES_CORENAMES') or ""
    if "scarthgap" in release:
        d.setVar('S', d.expand('${WORKDIR}/git'))
    else:
        pass
}

inherit cmake
DEPENDS += "lksctp-tools"

do_install() {
        install -d ${D}${bindir}
	install -m 0755 nr-ue ${D}${bindir}
	install -m 0755 nr-cli ${D}${bindir}
	#install -m 0755 nr-binder ${D}${bindir}
        #install -d ${D}${libdir}
	#install -m 0755 libdevbnd.so ${D}${libdir}
	#install -m 0755 nr-gnb ${D}${bindir}
}
