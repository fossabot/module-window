/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.module.coordinate;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
class CoordinatesTest {

    @Test
    void testCoordinatesIntIntIntInt() {
        BaseCoordinate c = new Coordinates(10, 15, 14, 16);
        assertEquals(10, c.width);
        assertEquals(15, c.height);
        assertEquals(14, c.left);
        assertEquals(16, c.top);
    }

    @Test
    void testCoordinatesSizeIntInt() {
        BaseCoordinate c = new Coordinates(new Size(10, 15), 14, 16);
        assertEquals(10, c.width);
        assertEquals(15, c.height);
        assertEquals(14, c.left);
        assertEquals(16, c.top);
        assertThrows(NullPointerException.class, () -> new Coordinates(null, 14, 16));
    }

    @Test
    void testCoordinatesSizePosition() {
        BaseCoordinate c = new Coordinates(new Size(10, 15), new Position(14, 16));
        assertEquals(15, c.height);
        assertEquals(10, c.width);
        assertEquals(14, c.left);
        assertEquals(16, c.top);
        assertThrows(NullPointerException.class, () -> new Coordinates(new Size(10, 15), null));
    }



    @Test
    void testGetSize() {
        Coordinates c = new Coordinates(10, 15, 14, 16);
        Size s = c.getSize();
        assertEquals(10, s.width);
        assertEquals(15, s.height);
    }

}
