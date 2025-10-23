<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
        xmlns:fo="http://www.w3.org/1999/XSL/Format"
        version="1.0">
    <xsl:output indent="yes" method="xml" standalone="no" omit-xml-declaration="no"/>

    <xsl:template match="/">
        <fo:root language="EN">
            <fo:layout-master-set>
                <fo:simple-page-master
                    master-name="A4-portrait" page-height="297mm"
                    page-width="210mm" margin-top="5mm"
                    margin-bottom="5mm" margin-left="5mm"
                    margin-right="5mm">
                    <fo:region-body/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4-portrait">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block vertical-align="top" text-align="center">
                        Employee list
                    </fo:block>

                    <xsl:for-each select="//department">
                        <fo:block font-size="14pt" font-weight="bolt" space-before="12pt" space-after="6pt">
                            <xsl:value-of select="departmentName"/>
                            <fo:table table-layout="fixed" width="100%" font-size="10pt" margin-bottom="10pt">
                                <fo:table-column column-width="proportional-column-width(50)"/>
                                <fo:table-column column-width="proportional-column-width(50)"/>
                                <fo:table-column column-width="proportional-column-width(50)"/>
                                <fo:table-column column-width="proportional-column-width(50)"/>
                                <fo:table-body font-size="100%">
                                    <fo:table-row height="8mm" border-color="grey" border-width="0.1mm" border-style="solid" text-align="center" display-align="center" space-after="5mm">
                                        <fo:table-cell>
                                            <fo:block>Name</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>Surname</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>Age</fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell>
                                            <fo:block>Position</fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                    <xsl:for-each select="employes">
                                        <fo:table-row text-align="start">
                                            <fo:table-cell>
                                                <fo:block><xsl:value-of select="firstName"/></fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell>
                                                <fo:block><xsl:value-of select="lastName"/></fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell>
                                                <fo:block><xsl:value-of select="age"/></fo:block>
                                            </fo:table-cell>
                                            <fo:table-cell>
                                                <fo:block><xsl:value-of select="position"/></fo:block>
                                            </fo:table-cell>
                                        </fo:table-row>
                                    </xsl:for-each>
                                </fo:table-body>
                            </fo:table>
                        </fo:block>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>

<!--
<fo:table table-layout="fixed" width="100%" font-size="10pt" margin-bottom="10pt">
                            <fo:table-header>
                                <fo:table-row background-color="#cccccc">
                                    <fo:table-cell padding="4pt"><fo:block>Name</fo:block></fo:table-cell>
                                    <fo:table-cell padding="4pt"><fo:block>Surname</fo:block></fo:table-cell>
                                    <fo:table-cell padding="4pt"><fo:block>age</fo:block></fo:table-cell>
                                    <fo:table-cell padding="4pt"><fo:block>position</fo:block></fo:table-cell>
                                </fo:table-row>
                            </fo:table-header>

                            <fo:table-body>
                                <xsl:for-each select="/employes">
                                    <fo:table-row>
                                        <fo:table-cell border="solid 1pt black" padding="4pt">
                                            <fo:block><xsl:value-of select="name"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1pt black" padding="4pt">
                                            <fo:block><xsl:value-of select="Surname"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1pt black" padding="4pt">
                                            <fo:block><xsl:value-of select="age"/></fo:block>
                                        </fo:table-cell>
                                        <fo:table-cell border="solid 1pt black" padding="4pt">
                                            <fo:block><xsl:value-of select="position"/></fo:block>
                                        </fo:table-cell>
                                    </fo:table-row>
                                </xsl:for-each>
                            </fo:table-body>
                        </fo:table>
-->