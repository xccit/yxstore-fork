import request from '@/utils/request'

const api_name = '/admin/product/attr'

export default {

  getList(groupId) {
    return request({
      url: `${api_name}/${groupId}`,
      method: 'get'
    })
  },
  getById(id) {
    return request({
      url: `${api_name}/get/${id}`,
      method: 'get'
    })
  },

  save(attr) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: attr
    })
  },

  updateById(attr) {
    return request({
      url: `${api_name}/update`,
      method: 'put',
      data: attr
    })
  },
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: 'delete'
    })
  },
  removeRows(idList) {
    return request({
      url: `${api_name}/batchRemove`,
      method: 'delete',
      data: idList
    })
  }
}
