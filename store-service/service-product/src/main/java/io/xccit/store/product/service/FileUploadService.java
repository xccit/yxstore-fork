package io.xccit.store.product.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author CH_ywx
 * @date 2023-06-15
 * @description
 */
public interface FileUploadService {
    String upload(MultipartFile file);
}
