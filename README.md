# thymeleaf mailto[![Build Status](https://travis-ci.org/ppi-ag/thymeleaf-mailto.svg?branch=master)](https://travis-ci.org/ppi-ag/thymeleaf-mailto)

Thymeleaf Dialect which helps to create mailto-links.

Supported attributes at anchor-tags "<a>" are:

- `mail:to`: the to-field of an email
- `mail:bcc`: the bcc-field of an email
- `mail:cc`: the cc-field of an email
- `mail:subject`: the subject-field of an email
- `mail:body`: the body-field of an email

The maximal lenght of the link is 507 characters otherwise IE will not show anything.

See the testdata at src/test/resources/thymeleaf/mailto.

To use codecompletion add `xmlns:mail="http://www.ppi.de/thymeleaf/mailto"` to the html-tag.

## Installation
Simply add
    <dependency>
        <groupId>de.ppi.oss</groupId>
        <artifactId>thymeleaf-mailto</artifactId>
        <version>0.1</version>
    </dependency>
