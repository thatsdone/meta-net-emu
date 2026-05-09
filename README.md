# meta-net-emu

Yocto layer for network emulators.

## Description

This layer supports installation of the following emulation tools:
* UERANSIM
    * An open source emulator for 3GPP 5G UE and RAN(gNodeB) maintained at:
      https://github.com/aligungr/UERANSIM
    * Currently, the recipe is intended for only client (UE) side, thus it installs only nr-ue and nr-cli.
* viwifi
    * An open source emulator for WiFi commication
    * This recipe installs all the vwifi binaries both server and client side.

## Yocto Project Compatible Layer

Tested under Yocto scarthgap and compatible distributions like
AGL (21.0.x, Ultimate Unagi).

## Dependencies

This recipe fetches the following repositories.

* UERANSIM
    * URI: https://github.com/aligungr/UERANSIM
    * branch: master
    * tag: v3.2.7

* vwifi
    * URI: https://github.com/Raizo62/vwifi
    * branch: master
    * tag: v4.6

These recipes have dependency on the following openembedded layers.

* openembedded-core
    * vwifi requires 'libnl'
* meta-openembedded/meta-oe
* meta-openembedded/meta-python
* meta-openembedded/meta-networking
    * UERANSIM requires 'lksctp-tools'

## Quick Start

In case of plain Yocto, run 'bitbake-layers add-layer PATH_TO/meta-net-emu'

Ensure that your environment has dependencies in your bblayers.conf.
Also, ensure that you have the following lines in your local.conf
depending on your choice.

```
IMAGE_INSTALL:append = " ueransim"
IMAGE_INSTALL:append = " vwifi"
```

## AGL Integration

AGL is a Yocto Linux based highly customized distribution.
Assuming your AGL_TOP directory is /opt/agl, create the following .inc file

/opt/agl/meta-agl-devel/templates/feature/agl-net-emu/50_bblayers.conf.inc

with the following content.
    
```
BBLAYERS =+ " \
        ${METADIR}/meta-agl-devel/meta-net-emu \
        "
```

You can use `agl/50_bblayers.conf.inc`.

Then, setup your build environment specifying 'agl-net-emu' to aglsetup.sh
script.

```
source meta-agl/scripts/aglsetup.sh \
    -m YOUR_TARGET_ARCHITECTURE(e.g., qemuarm64) \
    -b YOUR_BUILD_DIRECTORY \
    agl-devel agl-demo agl-net-emu
```

## Contributing

Please file an issue and send a PR.

## TODO
* UERANSIM: Make it configurable to install nr-gnb (gNodeB)
* vwifi: Improve debug symbol strip handling

## License

Note that UERANSIM is distributed under GPL-3.0 and vwifi is LGPL 3.0,
but this recipe is Apache-2.0.
    
## Maintainers

* Masanori Itoh `<masanori.itoh@gmail.com>`


