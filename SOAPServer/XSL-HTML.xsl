<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
   <xsl:template match="/company">
      <html>
         <body>
            <h1>UAB Company employes list</h1>
            <xsl:for-each select="//department">
               <table border="1">
                  <h2><xsl:value-of select="departmentName"/></h2>
                  <tr bgcolor="#9acd32">
                     <th>Name</th>
                     <th>Surname</th>
                     <th>Age</th>
                     <th>Position</th>
                     <xsl:for-each select ="employes">
                        <tr>
                           <td><xsl:value-of select = "firstName"/></td>
                           <td><xsl:value-of select = "lastName"/></td>
                           <td><xsl:value-of select = "age"/></td>
                           <td><xsl:value-of select = "position"/></td>
                        </tr>
                     </xsl:for-each>
                  </tr>
               </table>
            </xsl:for-each>
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>

