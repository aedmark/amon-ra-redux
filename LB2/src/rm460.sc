;;; Sierra Script 1.0 - (do not remove this comment)
(script# 460)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use PursuitRgn)
(use PChase)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm460 0
)

(local
	local0
	local1
	[theSel_87 44] = [83 148 64 168 297 169 296 154 246 154 246 138 217 141 229 146 230 157 189 157 187 146 187 138 162 139 174 150 160 160 104 152 144 141 102 146 103 120 72 120 92 123 96 146]
	[theSel_87_2 30] = [70 160 64 168 297 169 296 154 246 154 246 138 217 141 229 146 230 157 189 157 187 146 187 138 162 139 174 150 160 160]
	[theSel_87_3 46] = [83 148 64 168 297 169 296 154 270 154 280 119 269 141 217 141 229 146 230 157 189 157 187 146 187 138 162 139 174 150 160 160 119 155 144 141 102 146 103 120 72 120 92 123 96 146]
	[theSel_87_4 30] = [73 156 64 168 297 169 296 154 274 154 277 120 267 139 217 141 229 146 230 157 189 157 187 146 187 138 162 139 170 156]
)
(instance rm460 of LBRoom
	(properties
		sel_20 {rm460}
		sel_213 1
		sel_408 460
		sel_410 660
		sel_412 448
		sel_108 20
	)
	
	(method (sel_110)
		(proc958_0 128 460 462 461 858 423 424)
		(proc958_0 132 462 460)
		(self sel_414: 94)
		(gEgo sel_110: sel_320: 165 sel_585: 426)
		(switch gGSel_40
			(sel_412
				(gEgo sel_1: 84 sel_0: 122 sel_349: 0 sel_253: 135)
				(shoveCrate sel_1: 261)
				(self sel_146: sEnter)
				(global2 sel_395: (poly460a sel_110: sel_117:))
				(crane sel_110: sel_313:)
				(moverCrate sel_110: sel_313: sel_311: 4)
			)
			(sel_410
				(gEgo sel_153: 105 135 sel_349: 0 sel_253: 135)
				(cond 
					((proc0_2 103)
						(global2 sel_395: (poly460d sel_110: sel_117:))
						(crane sel_110: sel_313: sel_4: (crane sel_246:))
						(moverCrate
							sel_110:
							sel_313:
							sel_2: 462
							sel_3: 2
							sel_1: 108
							sel_0: 153
							sel_4: 0
							sel_311: 4
						)
					)
					((proc0_2 102)
						(global2 sel_395: (poly460d sel_110: sel_117:))
						(crane sel_110: sel_313: sel_4: (crane sel_246:))
						(moverCrate
							sel_110:
							sel_313:
							sel_4: (moverCrate sel_246:)
							sel_311: 4
						)
					)
					(else
						(global2 sel_395: (poly460c sel_110: sel_117:))
						(crane sel_110: sel_313:)
						(moverCrate sel_110: sel_313: sel_311: 4)
					)
				)
				(shoveCrate sel_1: 281)
			)
			(else 
				(gEgo sel_153: 211 160)
				(gGame sel_588:)
			)
		)
		(super sel_110:)
		(smashedDoor sel_110: sel_316: sel_317:)
		(shoveCrate sel_110: sel_313: sel_155: 3)
		(elevatorDoor sel_110: sel_313:)
		(floor sel_110:)
		(pipe sel_110: sel_311: 1 4 8)
		(cable sel_110: sel_311: 1 4 21)
		(ties sel_110: sel_311: 1 4)
		(crate1 sel_110: sel_311: 1 4 8)
		(crate2 sel_110: sel_311: 1 4 8)
		(crate3 sel_110: sel_311: 1 4 8)
		(crate4 sel_110: sel_311: 1 4 8)
		(crate5 sel_110: sel_311: 1 4 8)
		(crate6 sel_110: sel_311: 1 4 8)
		(darkCrates sel_110: sel_311: 1 4 8)
		(PursuitRgn sel_669:)
	)
	
	(method (sel_403)
		(if (global2 sel_142?)
			((global2 sel_142?) sel_65: sDie)
		else
			(global2 sel_146: sDie)
		)
	)
)

(instance sEnter of Script
	(properties
		sel_20 {sEnter}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 100 140 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sDie of Script
	(properties
		sel_20 {sDie}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 211 160 self)
			)
			(1
				(oriley
					sel_110:
					sel_320: 165
					sel_312: PolyPath 100 140 self
				)
				(gSel_608 sel_40: 3 sel_99: 1 sel_3: 1 sel_39:)
			)
			(2
				(if (proc0_2 102) (= sel_136 1) else (self sel_144: 4))
			)
			(3
				(oriley sel_2: 424 sel_161: Fwd)
				(moverCrate sel_161: End self)
				(splinters sel_110: sel_161: End)
				(gGameMusic2 sel_40: 444 sel_99: 5 sel_3: 1 sel_39:)
			)
			(4
				(oriley
					sel_2: 423
					sel_161: Walk
					sel_312: PChase gEgo 22 self
				)
			)
			(5
				(oriley sel_2: 424)
				(oriley sel_4: 0)
				(proc0_5 gEgo oriley)
				(proc0_5 oriley gEgo)
				(= sel_136 4)
			)
			(6 (oriley sel_161: End self))
			(7
				(thudSound sel_39:)
				(gEgo sel_2: 858 sel_161: End self)
			)
			(8
				(= global145 0)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sMoveCrate of Script
	(properties
		sel_20 {sMoveCrate}
	)
	
	(method (sel_57)
		(super sel_57:)
		(if (and local1 (== (shoveCrate sel_1?) 281))
			(gGameMusic2 sel_167:)
			(= local1 0)
		)
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(PursuitRgn sel_669:)
				(= local0 1)
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 243 134 self)
			)
			(1
				(gEgo
					sel_2: 461
					sel_3: 2
					sel_4: 0
					sel_153: 256 136
					sel_161: CT 2 1 self
				)
			)
			(2
				(gGameMusic2 sel_40: 721 sel_99: 5 sel_3: 1 sel_39:)
				(= local1 1)
				(gEgo sel_161: End self)
				(shoveCrate sel_312: MoveTo 281 140 self)
			)
			(3 0)
			(4
				((global2 sel_259?) sel_119: 111 sel_125:)
				(= sel_136 1)
			)
			(5
				(shoveCrate sel_313:)
				(global2
					sel_395:
						(if (proc0_2 102)
							(poly460d sel_110: sel_117:)
						else
							(poly460c sel_110: sel_117:)
						)
				)
				(gEgo sel_585: 426)
				(= sel_136 1)
			)
			(6
				(gEgo sel_312: MoveTo (gEgo sel_1?) 140 self)
			)
			(7
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sCutRope of Script
	(properties
		sel_20 {sCutRope}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(PursuitRgn sel_669:)
				(gEgo
					sel_2: 461
					sel_3: 1
					sel_4: 0
					sel_153: 196 147
					sel_161: End self
				)
			)
			(1
				(gGameMusic2 sel_40: 460 sel_99: 1 sel_39:)
				(moverCrate
					sel_155: 3
					sel_153: 108 32
					sel_4: 0
					sel_161: End self
				)
				(cable sel_161: End self)
			)
			(2
				(gGameMusic2 sel_40: 462 sel_99: 1 sel_39:)
			)
			(3
				(moverCrate
					sel_2: 462
					sel_155: 2
					sel_4: 0
					sel_153: 108 153
					sel_316: 0
				)
				(gEgo sel_585: 426)
				(gEgo sel_312: MoveTo 177 149 self)
			)
			(4
				(gGame sel_588:)
				(moverCrate sel_313:)
				(proc0_3 103)
				(self sel_111:)
			)
		)
	)
)

(instance sSwingIt of Script
	(properties
		sel_20 {sSwingIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(PursuitRgn sel_669:)
				(gGame sel_587:)
				(gEgo sel_63: 13)
				(gEgo sel_312: MoveTo 153 148 self)
			)
			(1
				(proc0_5 gEgo crane)
				(= sel_136 1)
			)
			(2
				(gEgo
					sel_2: 461
					sel_3: 0
					sel_4: 0
					sel_63: 14
					sel_161: End self
				)
				(crane sel_161: End self)
				(moverCrate sel_161: End self)
			)
			(3 0)
			(4 0)
			(5
				((global2 sel_259?) sel_119: 111)
				((global2 sel_259?) sel_125:)
				(= sel_136 1)
			)
			(6
				(global2
					sel_395:
						(if local0
							(poly460d sel_110: sel_117:)
						else
							(poly460b sel_110: sel_117:)
						)
				)
				(gEgo sel_585: 426)
				(gEgo sel_312: MoveTo 184 159 self)
			)
			(7
				(gGame sel_588:)
				(crane sel_313:)
				(moverCrate sel_313:)
				(proc0_3 102)
				(gEgo sel_63: -1)
				(self sel_111:)
			)
		)
	)
)

(instance splinters of Prop
	(properties
		sel_20 {splinters}
		sel_1 116
		sel_0 114
		sel_2 462
		sel_3 3
	)
)

(instance oriley of Actor
	(properties
		sel_20 {oriley}
		sel_1 84
		sel_0 122
		sel_2 424
	)
)

(instance cable of Prop
	(properties
		sel_20 {cable}
		sel_1 202
		sel_0 53
		sel_213 18
		sel_303 184
		sel_304 147
		sel_2 460
		sel_3 4
		sel_14 16384
	)
	
	(method (sel_300 param1)
		(switch param1
			(21
				(if (proc0_2 102)
					(global2 sel_146: sCutRope)
				else
					(gLb2Messager sel_295: 18 22 1)
				)
			)
			(22
				(if (proc0_2 102)
					(global2 sel_146: sCutRope)
				else
					(gLb2Messager sel_295: 18 22 1)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance shoveCrate of Actor
	(properties
		sel_20 {shoveCrate}
		sel_1 261
		sel_0 140
		sel_82 50
		sel_213 14
		sel_2 461
		sel_3 3
		sel_60 11
		sel_14 16
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (and (not (== gGSel_40 660)) (not local0))
					(global2 sel_146: sMoveCrate)
				else
					(super sel_300: param1 &rest)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance crane of Prop
	(properties
		sel_20 {crane}
		sel_1 213
		sel_0 57
		sel_213 17
		sel_2 460
		sel_60 11
		sel_14 16
	)
)

(instance moverCrate of Prop
	(properties
		sel_20 {moverCrate}
		sel_1 135
		sel_0 57
		sel_213 19
		sel_303 182
		sel_304 153
		sel_2 460
		sel_3 1
		sel_60 11
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(if (proc0_2 102)
					(super sel_300: param1 &rest)
				else
					(global2 sel_146: sSwingIt)
				)
			)
			(else 
				(super sel_300: param1 &rest)
			)
		)
	)
)

(instance elevatorDoor of Door
	(properties
		sel_20 {elevatorDoor}
		sel_1 268
		sel_0 131
		sel_303 265
		sel_304 144
		sel_2 462
		sel_589 660
		sel_597 274
		sel_598 133
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 266 123 290 123 290 134 266 134)
	)
)

(instance smashedDoor of View
	(properties
		sel_20 {smashedDoor}
		sel_1 117
		sel_0 5
		sel_82 -90
		sel_213 5
		sel_2 462
		sel_3 1
		sel_60 10
		sel_14 16
	)
)

(instance pipe of Feature
	(properties
		sel_20 {pipe}
		sel_1 208
		sel_0 89
		sel_213 16
		sel_6 57
		sel_7 205
		sel_8 122
		sel_9 212
		sel_301 40
		sel_303 186
		sel_304 151
	)
)

(instance ties of Feature
	(properties
		sel_20 {ties}
		sel_1 209
		sel_0 177
		sel_213 3
		sel_6 122
		sel_7 205
		sel_8 132
		sel_9 213
		sel_301 40
		sel_303 184
		sel_304 147
	)
)

(instance crate1 of Feature
	(properties
		sel_20 {crate1}
		sel_1 15
		sel_0 47
		sel_213 8
		sel_6 54
		sel_8 141
		sel_9 30
		sel_301 40
		sel_303 77
		sel_304 155
	)
)

(instance crate2 of Feature
	(properties
		sel_20 {crate2}
		sel_1 50
		sel_0 45
		sel_213 9
		sel_6 106
		sel_7 31
		sel_8 145
		sel_9 69
		sel_301 40
		sel_303 83
		sel_304 156
	)
)

(instance crate3 of Feature
	(properties
		sel_20 {crate3}
		sel_1 155
		sel_0 49
		sel_213 10
		sel_6 76
		sel_7 133
		sel_8 103
		sel_9 178
		sel_301 40
		sel_303 141
		sel_304 145
	)
)

(instance crate4 of Feature
	(properties
		sel_20 {crate4}
		sel_1 154
		sel_0 49
		sel_213 11
		sel_6 104
		sel_7 126
		sel_8 135
		sel_9 182
		sel_301 40
		sel_303 174
		sel_304 146
	)
)

(instance crate5 of Feature
	(properties
		sel_20 {crate5}
		sel_1 209
		sel_0 44
		sel_213 12
		sel_6 73
		sel_7 193
		sel_8 96
		sel_9 225
		sel_301 40
		sel_303 182
		sel_304 144
	)
)

(instance crate6 of Feature
	(properties
		sel_20 {crate6}
		sel_1 210
		sel_0 47
		sel_213 13
		sel_6 99
		sel_7 185
		sel_8 136
		sel_9 236
		sel_301 40
		sel_303 223
		sel_304 145
	)
)

(instance darkCrates of Feature
	(properties
		sel_20 {darkCrates}
		sel_1 159
		sel_0 179
		sel_213 6
		sel_6 170
		sel_8 189
		sel_9 319
		sel_301 40
		sel_303 198
		sel_304 165
	)
)

(instance floor of Feature
	(properties
		sel_20 {floor}
		sel_1 195
		sel_0 55
		sel_213 4
		sel_6 142
		sel_7 71
		sel_8 169
		sel_9 319
		sel_301 40
	)
)

(instance poly460a of Polygon
	(properties
		sel_20 {poly460a}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 22)
		(= sel_87 @theSel_87)
	)
)

(instance poly460b of Polygon
	(properties
		sel_20 {poly460b}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 15)
		(= sel_87 @theSel_87_2)
	)
)

(instance poly460c of Polygon
	(properties
		sel_20 {poly460c}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 23)
		(= sel_87 @theSel_87_3)
	)
)

(instance poly460d of Polygon
	(properties
		sel_20 {poly460d}
	)
	
	(method (sel_110)
		(= sel_31 3)
		(= sel_86 15)
		(= sel_87 @theSel_87_4)
	)
)

(instance thudSound of Sound
	(properties
		sel_20 {thudSound}
		sel_99 5
		sel_40 80
	)
)
