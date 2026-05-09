SUMMARY = "vwifi"
DESCRIPTION = "Yocto Recipe for vwifi"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/LGPL-3.0-only;md5=bfccfe952269fff2b407dd11f2f3083b"

SRC_URI = "git://github.com/Raizo62/vwifi;protocol=https;branch=master"
# v6.4 (latest as of Apr 4, 2025)
SRCREV_default = "20f99ee67c5281493ce68e80546b6efc9a710eae"

S = "${WORKDIR}/git"

#inherit make
DEPENDS += "libnl"
INSANE_SKIP:${PN} += "already-stripped"

do_install() {
install -d ${D}${bindir}
       	install -d ${D}${bindir}
	install -m 0755 vwifi-add-interfaces ${D}${bindir}
	install -m 0755 vwifi-client ${D}${bindir}
	install -m 0755 vwifi-ctrl ${D}${bindir}
	install -m 0755 vwifi-server ${D}${bindir}
}
