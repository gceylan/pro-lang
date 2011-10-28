#!/usr/bin/env python
#-*- coding: utf-8 -*-


def make_empty(seq):
    if type(seq) == type(''):
        return ''
    if type(seq) == type([]):
        return []
    else:
        return ()
