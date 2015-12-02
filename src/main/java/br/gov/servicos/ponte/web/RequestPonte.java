package br.gov.servicos.ponte.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.Map;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
public class RequestPonte {
    String appId;
    String session;
    String action;
    Map<String, String> params;
}