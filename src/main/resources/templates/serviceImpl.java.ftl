package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

  @Override
  public QueryWrapper<${entity}> getWrapper(Map< String, Object> params){
    String id= (String) params.get("id");

    QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
    wrapper.eq(StringUtils.isNotBlank(id),"id",id);
    return wrapper;
  }


}
