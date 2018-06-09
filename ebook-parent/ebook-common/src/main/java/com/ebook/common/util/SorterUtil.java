package com.ebook.common.util;

import java.util.Comparator;

import com.ebook.common.dto.ChapterDTO;
import com.ebook.common.dto.PartDTO;
import com.ebook.common.dto.SectionDTO;

public class SorterUtil {

	public static Comparator<PartDTO> partComparator = (p1, p2) -> {
		return p1.getPartNumber().compareTo(p2.getPartNumber());
	};

	public static Comparator<SectionDTO> sectionComparator = (s1, s2) -> {
		return s1.getSectionNumber().compareTo(s2.getSectionNumber());
	};
	public static Comparator<ChapterDTO> chapterComparator = (c1, c2) -> {
		return c1.getChapterNumber().compareTo(c2.getChapterNumber());
	};
}
