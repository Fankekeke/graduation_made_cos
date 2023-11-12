<template>
  <a-drawer
    title="新增学校"
    :maskClosable="false"
    width=650
    placement="right"
    :closable="false"
    @close="onClose"
    :visible="schoolAddVisiable"
    style="height: calc(100% - 55px);overflow: auto;padding-bottom: 53px;">
    <a-form :form="form">
      <a-form-item label="学校名称" v-bind="formItemLayout">
        <a-input v-decorator="['name',{rules: [{ required: true, message: '请填写学校名称' }]}]"/>
      </a-form-item>
      <a-form-item label="学校地址" v-bind="formItemLayout">
        <a-input v-decorator="['address',{rules: [{ required: true, message: '请填写学校地址' }]}]"/>
      </a-form-item>
      <a-form-item label="所在城市" v-bind="formItemLayout">
        <a-select
          :allowClear="true"
          style="width: 100%"
          show-search
          :default-active-first-option="false"
          :show-arrow="false"
          :filter-option="false"
          @search="handleSearch"
          v-decorator="['cityId',{rules: [{ required: true, message: '请选择所在城市' }]}]">
          <a-select-option v-for="r in cityData" :key="r.id">{{r.name}}</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="主管部门" v-bind="formItemLayout">
        <a-input v-decorator="['manage']"/>
      </a-form-item>
      <a-form-item label="学校地区" v-bind="formItemLayout">
        <a-input v-decorator="['area']"/>
      </a-form-item>
      <a-form-item label="人 数" v-bind="formItemLayout">
        <a-input-number v-decorator="['number']" :min="1" :step="1" style="width: 100%"/>
      </a-form-item>
      <a-form-item label="网 址" v-bind="formItemLayout">
        <a-input v-decorator="['http']"/>
      </a-form-item>
      <a-form-item label="层 次" v-bind="formItemLayout">
        <a-input v-decorator="['level']"/>
      </a-form-item>
      <a-form-item label="类 型" v-bind="formItemLayout">
        <a-input v-decorator="['type']"/>
      </a-form-item>
      <a-form-item label="备 注" v-bind="formItemLayout">
        <a-textarea v-decorator="['desc']"/>
      </a-form-item>
    </a-form>
      <div class="drawer-bootom-button">
        <a-popconfirm title="确定放弃编辑？" @confirm="onClose" okText="确定" cancelText="取消">
          <a-button style="margin-right: .8rem">取消</a-button>
        </a-popconfirm>
        <a-button @click="handleSubmit" type="primary" :loading="loading">提交</a-button>
      </div>
  </a-drawer>
</template>
<script>
const formItemLayout = {
  labelCol: { span: 3 },
  wrapperCol: { span: 18 }
}
export default {
  name: 'SchoolAdd',
  props: {
    schoolAddVisiable: {
      default: false
    }
  },
  data () {
    return {
      school: {},
      loading: false,
      formItemLayout,
      form: this.$form.createForm(this),
      cityData: []
    }
  },
  methods: {
    handleSearch(value) {
      if (value) {
        this.$get(`/cos/sys-city/united/${value}`).then((r) => {
          this.cityData = r.data.data
        })
      }
    },
    reset () {
      this.loading = false
      this.form.resetFields()
    },
    onClose () {
      this.reset()
      this.$emit('close')
    },
    handleSubmit () {
      this.form.validateFields((err, values) => {
        if (!err) {
          this.loading = true
          this.school = values
          this.$post('/cos/sys-school', {
            ...this.school
          }).then((r) => {
            this.reset()
            this.$emit('success')
          }).catch(() => {
            this.loading = false
          })
        }
      })
    }
  },
  watch: {}
}
</script>
