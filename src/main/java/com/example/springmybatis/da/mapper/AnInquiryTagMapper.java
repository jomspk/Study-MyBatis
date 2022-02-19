package com.example.springmybatis.da.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.springmybatis.da.entity.InquiryTag;

@Repository
@Mapper
public interface AnInquiryTagMapper {

    // TODO ハンズオン 8-1-1 find用のアノテーションを定義
	@Select({"		select id, inquiry_id, description, created", 
		"		from inquiry_tag", 
		"		where id = #{id}"})
    InquiryTag find(int id);

    // TODO ハンズオン 8-1-2 insert用のアノテーションを定義
	@Insert({"    	insert into inquiry_tag(inquiry_id, description, created)", 
	"    	values (#{inquiryId},#{description},#{created})"})
    void insert(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-3 update用のアノテーションを定義
	@Update({"<script>",
		"    	update inquiry_tag", 
			"    	<set>", 
			"    		inquiry_id = #{inquiryId},", 
			"    		description = #{description},", 
			"    		created = #{created},",
			"    	</set>",
			"    	where id = #{id}",
			"</script>"})
    void update(InquiryTag inquiryTag);

    // TODO ハンズオン 8-1-4 delete用のアノテーションを定義
	@Delete({"    	delete from inquiry_tag", 
	"    	where id = #{id}"})
	void delete(int id);

}
