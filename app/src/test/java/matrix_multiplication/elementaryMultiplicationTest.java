package matrix_multiplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class elementaryMultiplicationTest {

    private static Matrix m2;
    private static Matrix m2_squared;
    private static Matrix m2_squared_wrong;
    private static Matrix m4;
    private static Matrix m4_squared;
    private static Matrix m4_squared_wrong;
    private static Matrix m8;
    private static Matrix m8_squared;
    private static Matrix m8_squared_wrong;
    private static Matrix m16;
    private static Matrix m16_squared;
    private static Matrix m16_squared_wrong;

    @Before
    public void init() {
        m2 = new Matrix(2, 2, new double[] { 1, 2, 3, 4 });
        m2_squared = new Matrix(2, 2, new double[] { 7, 10, 15, 22 });
        m2_squared_wrong = new Matrix(2, 2, new double[] { 1, 1, 1, 1 });

        m4 = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
        m4_squared = new Matrix(4, 4,
                new double[] { 90, 100, 110, 120, 202, 228, 254, 280, 314, 356, 398, 440, 426, 484, 542, 600 });
        m4_squared_wrong = new Matrix(4, 4,
                new double[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});

        m8 = new Matrix(8, 8, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });
        m8_squared = new Matrix(8, 8,
                new double[] { 1380, 1416, 1452, 1488, 1524, 1560, 1596, 1632, 3236, 3336, 3436, 3536, 3636, 3736, 3836,
                        3936, 5092, 5256, 5420, 5584, 5748, 5912, 6076, 6240, 6948, 7176, 7404, 7632, 7860, 8088, 8316,
                        8544, 8804, 9096, 9388, 9680, 9972, 10264, 10556, 10848, 10660, 11016, 11372, 11728, 12084,
                        12440, 12796, 13152, 12516, 12936, 13356, 13776, 14196, 14616, 15036, 15456, 14372, 14856,
                        15340, 15824, 16308, 16792, 17276, 17760 });
        m8_squared_wrong = new Matrix(8, 8,
            new double[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 });

        m16 = new Matrix(16, 16, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73,
                74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
                121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141,
                142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162,
                163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
                184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204,
                205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225,
                226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246,
                247, 248, 249, 250, 251, 252, 253, 254, 255, 256 });
        m16_squared = new Matrix(16, 16, new double[] { 21896, 22032, 22168, 22304, 22440, 22576, 22712, 22848, 22984,
                23120, 23256, 23392, 23528, 23664, 23800, 23936, 52872, 53264, 53656, 54048, 54440, 54832, 55224, 55616,
                56008, 56400, 56792, 57184, 57576, 57968, 58360, 58752, 83848, 84496, 85144, 85792, 86440, 87088, 87736,
                88384, 89032, 89680, 90328, 90976, 91624, 92272, 92920, 93568, 114824, 115728, 116632, 117536, 118440,
                119344, 120248, 121152, 122056, 122960, 123864, 124768, 125672, 126576, 127480, 128384, 145800, 146960,
                148120, 149280, 150440, 151600, 152760, 153920, 155080, 156240, 157400, 158560, 159720, 160880, 162040,
                163200, 176776, 178192, 179608, 181024, 182440, 183856, 185272, 186688, 188104, 189520, 190936, 192352,
                193768, 195184, 196600, 198016, 207752, 209424, 211096, 212768, 214440, 216112, 217784, 219456, 221128,
                222800, 224472, 226144, 227816, 229488, 231160, 232832, 238728, 240656, 242584, 244512, 246440, 248368,
                250296, 252224, 254152, 256080, 258008, 259936, 261864, 263792, 265720, 267648, 269704, 271888, 274072,
                276256, 278440, 280624, 282808, 284992, 287176, 289360, 291544, 293728, 295912, 298096, 300280, 302464,
                300680, 303120, 305560, 308000, 310440, 312880, 315320, 317760, 320200, 322640, 325080, 327520, 329960,
                332400, 334840, 337280, 331656, 334352, 337048, 339744, 342440, 345136, 347832, 350528, 353224, 355920,
                358616, 361312, 364008, 366704, 369400, 372096, 362632, 365584, 368536, 371488, 374440, 377392, 380344,
                383296, 386248, 389200, 392152, 395104, 398056, 401008, 403960, 406912, 393608, 396816, 400024, 403232,
                406440, 409648, 412856, 416064, 419272, 422480, 425688, 428896, 432104, 435312, 438520, 441728, 424584,
                428048, 431512, 434976, 438440, 441904, 445368, 448832, 452296, 455760, 459224, 462688, 466152, 469616,
                473080, 476544, 455560, 459280, 463000, 466720, 470440, 474160, 477880, 481600, 485320, 489040, 492760,
                496480, 500200, 503920, 507640, 511360, 486536, 490512, 494488, 498464, 502440, 506416, 510392, 514368,
                518344, 522320, 526296, 530272, 534248, 538224, 542200, 546176
        });
        m16_squared_wrong = new Matrix(16, 16, new double[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
        });

    }

    @Test
    public void elementaryMultiplicationTest_m2() {
        Matrix actual = Matrix.elementaryMultiplication(m2, m2);
        Matrix expected = m2_squared;
        assertEquals(expected, actual);
    }
    @Test
    public void elementaryMultiplicationTest_m2_wrong() {
        Matrix actual = Matrix.elementaryMultiplication(m2, m2);
        Matrix expected = m2_squared_wrong;
        assertNotEquals(expected, actual);
    }

    @Test
    public void elementaryMultiplicationTest_m4() {
        Matrix actual = Matrix.elementaryMultiplication(m4, m4);
        Matrix expected = m4_squared;
        assertEquals(expected, actual);
    }
    @Test
    public void elementaryMultiplicationTest_m4_wrong() {
        Matrix actual = Matrix.elementaryMultiplication(m4, m4);
        Matrix expected = m4_squared_wrong;
        assertNotEquals(expected, actual);
    }

    @Test
    public void elementaryMultiplicationTest_m8() {
        Matrix actual = Matrix.elementaryMultiplication(m8, m8);
        Matrix expected = m8_squared;
        assertEquals(expected, actual);
    }
    @Test
    public void elementaryMultiplicationTest_m8_wrong() {
        Matrix actual = Matrix.elementaryMultiplication(m8, m8);
        Matrix expected = m8_squared_wrong;
        assertNotEquals(expected, actual);
    }

    @Test
    public void elementaryMultiplicationTest_m16() {
        Matrix actual = Matrix.elementaryMultiplication(m16, m16);
        Matrix expected = m16_squared;
        assertEquals(expected, actual);
    }
    @Test
    public void elementaryMultiplicationTest_m16_wrong() {
        Matrix actual = Matrix.elementaryMultiplication(m16, m16);
        Matrix expected = m16_squared_wrong;
        assertNotEquals(expected, actual);
    }

}