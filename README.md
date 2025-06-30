# meta-cellular

Yocto layer for cellular network tools.

## Description

This layer supports installation of UERANSIM,
an open source emulator for 3GPP 5G UE and RAN(gNodeB)
maintained at:

https://github.com/aligungr/UERANSIM

Currently, the recipe is intended for only client (UE) side, thus
it installs only nr-ue and nr-cli.

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

Run 'bitbake-layers add-layer PATH_TO/meta-cellular'

Also ensure that your environment has dependencies in your bblayers.conf

Ensure that you have the following line in your local.conf.

```
IMAGE_INSTALL:append = " ueransim"
```
    
## Contributing

Please file an issue and send a PR.

## License

Note that UERANSIM is distributed under GPL-3.0, but this recipe is
Apache-2.0.
    
## Maintainers

* Masanori Itoh `<masanori.itoh@gmail.com>`


