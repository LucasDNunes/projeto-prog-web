package br.unisul.progweb.core.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class URL {

    public static String decodeParam(String param) {
        try {
            return URLDecoder.decode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("Erro DecodeParam", e);
            return "";
        }
    }

    public static List<Long> decodeIntList(String s) {
        String[] vetor = s.split(",");
        List<Long> list = new ArrayList<>();
        for (String vet : vetor) {
            list.add(Long.parseLong(vet));
        }
        return list;
    }

}
