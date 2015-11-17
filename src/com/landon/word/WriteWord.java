package com.landon.word;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;

import com.landon.entity.Entity;
import com.landon.entity.MediaEntity;
import com.landon.entity.PictureEntity;
import com.landon.entity.VideoEntity;

public class WriteWord {

	public void write2Word(String name) {
		List<Entity> data = Data.getSortedData();
		if (data == null || data.size() <= 0)
			return;
		XWPFDocument doc = null;

		OutputStream os;
		try {
			os = new FileOutputStream(name + System.currentTimeMillis() + ".docx");
			for (int i = 0; i < data.size(); ++i) {
				if (doc == null)
					doc = new XWPFDocument();
				XWPFParagraph paragraph = doc.createParagraph();
				XWPFRun run = paragraph.createRun();
				run.setBold(true);
				run.setText(Integer.toString(data.get(i).getID()) + "、" + data.get(i).getTitle());

				MediaEntity mediaEntity = data.get(i).getMedia();
				if (mediaEntity != null) {
					if (mediaEntity.getMediaType() == MediaEntity.TYPE_PICTURE) {
						PictureEntity pictureEntity = (PictureEntity) mediaEntity;
						paragraph = doc.createParagraph();

						doc.addPictureData(pictureEntity.getData(), getPictureType(pictureEntity.getPicType()));
						createPicture(doc, doc.getAllPictures().size() - 1, pictureEntity.getWidth(),
								pictureEntity.getHeight(), paragraph);
					} else if (mediaEntity.getMediaType() == MediaEntity.TYPE_VIDEO) {
						paragraph = doc.createParagraph();
						run = paragraph.createRun();
						run.setColor("FF0000");
						run.setText("此题包含视频，位置在：" + ((VideoEntity) mediaEntity).getPath());
					}
				}

				List<String> options = data.get(i).getOptions();
				String[] opts = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
				for (int j = 0; j < options.size(); ++j) {
					paragraph = doc.createParagraph();
					run = paragraph.createRun();
					run.setText(opts[j] + "、" + options.get(j));
				}

				paragraph = doc.createParagraph();
				run = paragraph.createRun();
				run.setText("");

				paragraph = doc.createParagraph();
				run = paragraph.createRun();
				String answers = "正确答案：";
				List<Integer> answerIndex = data.get(i).getAnswerIndex();
				for (int k = 0; k < answerIndex.size(); ++k) {
					answers += getAnswerOption(answerIndex.get(k)) + " ";
				}
				run.setText(answers);

				paragraph = doc.createParagraph();
				run = paragraph.createRun();
				String explain = data.get(i).getAnalysis();
				run.setText(explain);

				paragraph = doc.createParagraph();
				run = paragraph.createRun();
				run.setItalic(true);
				run.setText("");

			}

			try {
				doc.write(os);
				doc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}

	}

	private String getAnswerOption(int answer) {
		if (answer > 10)
			return null;
		String[] options = { "null", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K" };
		return options[answer];
	}

	/**
	 * 获取图片类型
	 * 
	 * @param type
	 *            图片类型字符串描述
	 * @return 图片类型整形描述
	 */
	private int getPictureType(String type) {
		if (type.toLowerCase().equals("jpg") || type.toLowerCase().equals("jpeg")) {
			return XWPFDocument.PICTURE_TYPE_JPEG;
		} else if (type.toLowerCase().equals("png")) {
			return XWPFDocument.PICTURE_TYPE_PNG;
		} else if (type.toLowerCase().equals("bmp")) {
			return XWPFDocument.PICTURE_TYPE_BMP;
		} else if (type.toLowerCase().equals("gif")) {
			return XWPFDocument.PICTURE_TYPE_GIF;
		}
		return 0;
	}

	/**
	 * @param id
	 * @param width
	 *            宽
	 * @param height
	 *            高
	 * @param paragraph
	 *            段落
	 */
	public void createPicture(XWPFDocument doc, int id, int width, int height, XWPFParagraph paragraph) {
		final int EMU = 9525;
		width *= EMU;
		height *= EMU;
		String blipId = doc.getAllPictures().get(id).getPackageRelationship().getId();
		CTInline inline = paragraph.createRun().getCTR().addNewDrawing().addNewInline();
		String picXml = "" + "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">"
				+ "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
				+ "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
				+ "         <pic:nvPicPr>" + "            <pic:cNvPr id=\"" + id + "\" name=\"Generated\"/>"
				+ "            <pic:cNvPicPr/>" + "         </pic:nvPicPr>" + "         <pic:blipFill>"
				+ "            <a:blip r:embed=\"" + blipId
				+ "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>"
				+ "            <a:stretch>" + "               <a:fillRect/>" + "            </a:stretch>"
				+ "         </pic:blipFill>" + "         <pic:spPr>" + "            <a:xfrm>"
				+ "               <a:off x=\"0\" y=\"0\"/>" + "               <a:ext cx=\"" + width + "\" cy=\""
				+ height + "\"/>" + "            </a:xfrm>" + "            <a:prstGeom prst=\"rect\">"
				+ "               <a:avLst/>" + "            </a:prstGeom>" + "         </pic:spPr>"
				+ "      </pic:pic>" + "   </a:graphicData>" + "</a:graphic>";

		inline.addNewGraphic().addNewGraphicData();
		XmlToken xmlToken = null;
		try {
			xmlToken = XmlToken.Factory.parse(picXml);
		} catch (XmlException xe) {
			xe.printStackTrace();
		}
		inline.set(xmlToken);

		inline.setDistT(0);
		inline.setDistB(0);
		inline.setDistL(0);
		inline.setDistR(0);

		CTPositiveSize2D extent = inline.addNewExtent();
		extent.setCx(width);
		extent.setCy(height);

		CTNonVisualDrawingProps docPr = inline.addNewDocPr();
		docPr.setId(id);
		docPr.setName("图片" + id);
		docPr.setDescr("测试");
	}
}
