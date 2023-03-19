<template>
  <button @click="show">显示html内容</button>

  <div style="border: 1px solid #ccc">
    <Toolbar
        style="border-bottom: 1px solid #ccc"
        :editor="editorRef"
        :defaultConfig="toolbarConfig"
        :mode="mode"
    />
    <Editor
        style="height: 500px; overflow-y: hidden;"
        v-model="valueHtml"
        :defaultConfig="editorConfig"
        :mode="mode"
        @onCreated="handleCreated"
    />
  </div>
</template>

<script setup>


import '@wangeditor/editor/dist/css/style.css' // 引入 css

import {onBeforeUnmount, ref, shallowRef, onMounted} from 'vue'
import {Editor, Toolbar} from '@wangeditor/editor-for-vue'
import myaxios from "@/config/myaxios";


// myaxios.get("/animer?id=8").then(repose => {
//   console.log(repose)
// }).catch(error => {
//   console.log(error)
// })

// export default {
//   components: { Editor, Toolbar },
//   setup() {
// 编辑器实例，必须用 shallowRef
const editorRef = shallowRef()

// 内容 HTML
// const valueHtml = ref('<p>hello</p>')

// // 模拟 ajax 异步获取内容
// onMounted(() => {
//   setTimeout(() => {
//     valueHtml.value = '<p>模拟 Ajax 异步设置内容</p>'
//   }, 1500)
// })

const toolbarConfig = {}
const editorConfig = {
  placeholder: '请输入内容...',
  MENU_CONF: {
    uploadImage: {
      server: 'http://127.0.0.1/api/posts/images',
      // maxFileSize: 1 * 1024 * 1024, // 1M
      // // 上传的图片类型
      // allowedFileTypes: ["image/*"],
      // header:{
      //   "Access-Control-Allow-Origin":"*"
      // },
      fieldName: 'imagefile',
      // 上传之前触发
      onBeforeUpload(file) { // TS 语法
        // onBeforeUpload(file) {    // JS 语法
        // file 选中的文件，格式如 { key: file }
        return file

        // 可以 return
        // 1. return file 或者 new 一个 file ，接下来将上传
        // 2. return false ，不上传这个 file
      },

      // 上传进度的回调函数
      onProgress(progress) {  // TS 语法
        // onProgress(progress) {       // JS 语法
        // progress 是 0-100 的数字
        console.log('progress', progress)
      },

      // 单个文件上传成功之后
      onSuccess(file, res) {  // TS 语法
        // onSuccess(file, res) {          // JS 语法
        console.log(`${file.name} 上传成功`, res)
      },

      // 单个文件上传失败
      onFailed(file, res) {   // TS 语法
        // onFailed(file, res) {           // JS 语法
        console.log(`${file.name} 上传失败`, res)
      },

      // 上传错误，或者触发 timeout 超时
      onError(file, err, res) {  // TS 语法
        // onError(file, err, res) {               // JS 语法
        console.log(`${file.name} 上传出错`, err, res)
      },
    }
  }
}


// 组件销毁时，也及时销毁编辑器
onBeforeUnmount(() => {
  const editor = editorRef.value
  if (editor == null) return
  editor.destroy()
})

const handleCreated = (editor) => {
  console.log(editor)

  editorRef.value = editor // 记录 editor 实例，重要！
}


// editorConfig.uploadImgServer = 'http://127.0.0.1/api/posts/images'


const show = () => {
  console.log(editorRef.value.getHtml());
}


// return {
//   editorRef,
//   valueHtml,
//   mode: 'default', // 或 'simple'
//   toolbarConfig,
//   editorConfig,
//   handleCreated
// };
// }
// }
</script>
