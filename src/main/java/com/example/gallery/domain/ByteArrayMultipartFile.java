package com.example.gallery.domain;

import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

// DB는 byte[] 타입의 이미지만 저장가능한데 frontend에서 image받아올때 dto로 reqestbody 쓰고싶어서 굳이굳이 타입변환 클래스 만듦

@NoArgsConstructor
public class ByteArrayMultipartFile implements MultipartFile {

    private byte[] bytes;
    private String name;
    private String originalFilename;
    private String contentType;

    public ByteArrayMultipartFile(byte[] bytes, String originalFilename) {
        this(bytes, null, originalFilename, null);
    }

    public ByteArrayMultipartFile(byte[] bytes, String name, String originalFilename, String contentType) {
        this.bytes = bytes;
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return (bytes == null || bytes.length == 0);
    }

    @Override
    public long getSize() {
        return (bytes == null) ? 0 : bytes.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return bytes;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(bytes);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        new FileOutputStream(dest).write(bytes);
    }
}
