package com.example.addressbook.dto;

import lombok.Data;



    public  @Data class ResponseDto {
        private String message;
        private Object data;
        public String token;


        public ResponseDto(String message, Object data , String token) {
            this.message = message;
            this.data = data;
            this.token= String.valueOf(token);

        }

    }

