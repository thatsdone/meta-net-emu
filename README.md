# meta-net-emu

Yocto layer for network emulators.

## Description

This layer supports installation of the following tools:
* UERANSIM
    * An open source emulator for 3GPP 5G UE and RAN(gNodeB) maintained at:
      https://github.com/aligungr/UERANSIM
    * Currently, the recipe is intended for only client (UE) side, thus it installs only nr-ue and nr-cli.

## Yocto Project Compatible Layer

Tested under Yocto scarthgap and compatible distributions like
AGL (19.0.x, Super Salmon).

## Dependencies

This recipe fetches the following UERANSIM source repository.

* URI: https://github.com/aligungr/UERANSIM
* branch: master
* tag: v3.2.7

This recipe has dependency on the following openembedded layers.

* meta-openembedded/meta-oe
* meta-openembedded/meta-python
* meta-openembedded/meta-networking
    * UERANSIM requires 'lksctp-tools'

## Quick Start

Run 'bitbake-layers add-layer PATH_TO/meta-net-emu'

Also ensure that your environment has dependencies in your bblayers.conf

Ensure that you have the following line in your local.conf.

```
IMAGE_INSTALL:append = " ueransim"
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

## License

Note that UERANSIM is distributed under GPL-3.0, but this recipe is
Apache-2.0.
    
## Maintainers

* Masanori Itoh `<masanori.itoh@gmail.com>`


