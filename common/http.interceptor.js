const install = (Vue, vm) => {
	Vue.prototype.$u.http.setConfig({
		//内网穿透(域名+/api)==>所有关于用户的请求前缀都是/api
		baseUrl: ' http://yxstore.free.idcfengye.com/api',
		loadingText: '请求中...', // 请求loading中的文字提示
		loadingTime: 800, // 在此时间内，请求还没回来的话，就显示加载中动画，单位ms
		loadingMask: true, // 展示loading的时候，是否给一个透明的蒙层，防止触摸穿透
	});
	 
	// 请求拦截，配置Token等参数
	Vue.prototype.$u.http.interceptor.request = (config) => {
		config.header.token = uni.getStorageSync('token')

		return config;
	}
	// 响应拦截，判断状态码是否通过
	Vue.prototype.$u.http.interceptor.response = (res) => {
		if (res.code == 200) {
			return res.data;
		} else if (res.code == 208) {
			// 未登陆，token过期
			uni.reLaunch({
				url:'/pages/login/login'
			})
			return false;
		} else {
			uni.showToast({
				title: res.message,
				icon: 'none'
			})
			return false;
		}
	}
}

export default {
	install
}
