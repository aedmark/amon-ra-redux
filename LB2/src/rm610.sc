;;; Sierra Script 1.0 - (do not remove this comment)
(script# 610)
(include sci.sh)
(use Main)
(use Door)
(use LBRoom)
(use ExitFeature)
(use MuseumRgn)
(use Scaler)
(use PolyPath)
(use CueObj)
(use MoveFwd)
(use n958)
(use Rev)
(use Timer)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm610 0
	northDoor 1
	eastDoor 2
)

(local
	[local0 15] = [-1 195 200 208 216 234 172 167 161 148 129 79 64 46 23]
	[local15 15] = [-1 132 136 145 151 150 127 132 136 144 154 138 139 143 150]
	[local30 15] = [-1 82 90 112 118 130 82 90 97 112 130 94 98 111 125]
	[local45 15] = [-1 10 13 22 32 41 10 13 20 29 41 17 20 22 30]
	local60
	gEgoSel_4_2 =  -1
	gEgoSel_4 =  -1
	local63
)
(instance rm610 of LBRoom
	(properties
		sel_20 {rm610}
		sel_213 29
		sel_408 610
		sel_409 630
		sel_410 640
		sel_411 600
		sel_107 165
		sel_108 88
	)
	
	(method (sel_110)
		(gEgo sel_110: sel_585: 831 sel_320: Scaler 123 0 190 88)
		(self sel_414: 90)
		(switch gGSel_40
			(sel_409
				(gEgo sel_349: 0 sel_253: 180)
				(northDoor sel_143: self)
			)
			(sel_410
				(gEgo sel_349: 0 sel_253: 270)
				(eastDoor sel_143: self)
			)
			(sel_411
				(global2 sel_146: sEnterSouth self)
			)
			(620
				(self sel_146: sClimbDownVat)
				(if (gEgo sel_238: 11) (gIconBar sel_177: 7))
			)
			(666
				(Palette palSET_INTENSITY 0 255 100)
				(gEgo sel_153: 84 132)
				(self sel_146: sEnterFromTunnel)
			)
			(26
				(self sel_146: sClimbDownVat)
			)
			(else 
				(gEgo sel_584: 1 sel_153: 160 160)
				(gGame sel_588:)
			)
		)
		(gGameMusic2 sel_40: 610 sel_3: -1 sel_99: 1 sel_39:)
		(super sel_110:)
		(proc958_0 128 611 612)
		(northDoor sel_110:)
		(if
			(or
				(and (== global123 3) (proc0_10 4104))
				(>= global123 4)
				(not (proc0_2 50))
			)
			(northDoor sel_590: 0)
		else
			(northDoor sel_590: 1)
		)
		(eastDoor sel_110:)
		(if (and (proc0_2 18) (not (proc0_2 4)))
			(eastDoor sel_590: 1)
		)
		(oilJar
			sel_156:
				(cond 
					((proc0_2 105) 3)
					((proc0_2 106) 2)
					((proc0_2 107) 1)
					(else 0)
				)
			sel_311: 1 4 8 25
			sel_110:
			sel_6: 140
			sel_7: 4
			sel_8: 189
			sel_9: 72
		)
		(sink sel_311: 25 8 sel_110:)
		(desk sel_311: 25 8 sel_110:)
		(drain sel_311: 25 8 sel_110:)
		(light sel_110:)
		(funnel sel_110:)
		(longPipe sel_110:)
		(shortPipe sel_110:)
		(southExit sel_110:)
		(if
			(and
				(proc0_2 20)
				(not (== gGSel_40 620))
				(not (== gGSel_40 26))
			)
			(sHeimlichMusic sel_39:)
			(MuseumRgn sel_645:)
			((ScriptID 32 0)
				sel_110:
				sel_2: 814
				sel_620: 610
				sel_153: 228 153
				sel_320: 156
				sel_3: 1
			)
			(= local60 1)
		else
			(vat14
				sel_311: 4
				sel_303: [local0 14]
				sel_304:
					[local15 (vat13
						sel_311: 4
						sel_303: [local0 13]
						sel_304:
							[local15 (vat12
								sel_311: 4
								sel_303: [local0 12]
								sel_304:
									[local15 (vat11
										sel_311: 4
										sel_303: [local0 11]
										sel_304:
											[local15 (vat10
												sel_303: [local0 10]
												sel_304:
													[local15 (vat9
														sel_311: 4
														sel_303: [local0 9]
														sel_304:
															[local15 (vat8
																sel_311: 4
																sel_303: [local0 8]
																sel_304:
																	[local15 (vat7
																		sel_311: 4
																		sel_303: [local0 7]
																		sel_304:
																			[local15 (vat6
																				sel_311: 4
																				sel_303: [local0 6]
																				sel_304:
																					[local15 (vat5
																						sel_311: 4
																						sel_303: [local0 5]
																						sel_304:
																							[local15 (vat4
																								sel_311: 4
																								sel_303: [local0 4]
																								sel_304:
																									[local15 (vat3
																										sel_311: 4
																										sel_303: [local0 3]
																										sel_304:
																											[local15 (vat2
																												sel_311: 4
																												sel_303: [local0 2]
																												sel_304:
																													[local15 (vat1
																														sel_311: 4
																														sel_303: [local0 1]
																														sel_304: [local15 (Load rsSOUND 40)]
																														sel_110:
																													)]
																												sel_110:
																											)]
																										sel_110:
																									)]
																								sel_110:
																							)]
																						sel_110:
																					)]
																				sel_110:
																			)]
																		sel_110:
																	)]
																sel_110:
															)]
														sel_110:
													)]
												sel_311: 4
												sel_110:
											)]
										sel_110:
									)]
								sel_110:
							)]
						sel_110:
					)]
				sel_110:
			)
		)
	)
	
	(method (sel_57)
		(if
			(and
				(== (gEgo sel_349?) 3)
				(& ((gIconBar sel_64: 7) sel_14?) $0004)
			)
			(gIconBar sel_177: 7)
		)
		(if
		(and (not (global2 sel_142?)) (proc0_1 gEgo 64))
			(global2 sel_146: sExitSouth)
		)
		(super sel_57:)
	)
	
	(method (sel_111)
		(if (and (not (== gTheGSel_40 620)) (proc0_2 20))
			(proc0_4 21)
			((ScriptID 90 13) sel_162: (ScriptID 90 13) 30)
		)
		(if (!= gTheGSel_40 620) (gGameMusic2 sel_170:))
		(kickTimer sel_111: sel_81:)
		(sHeimlichMusic sel_170:)
		(super sel_111:)
	)
	
	(method (sel_145)
		(cond 
			(local60 (global2 sel_146: sKickOut))
			((and (not (proc0_2 154)) (not (proc0_2 4)))
				(if
					(not
						(if (and (== global123 3) (proc0_10 -20222))
							(not (proc0_10 4880))
						)
					)
					(eastDoor sel_146: sWaterPrompt)
				)
			)
		)
		(if
			(and
				(== global123 4)
				(proc0_10 12290 1)
				(not (proc0_10 12290))
			)
			((ScriptID 90 15) sel_137: 2)
			(= global111 15)
		)
	)
)

(instance sExitSouth of Script
	(properties
		sel_20 {sExitSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gIconBar sel_177: 7)
				(gGame sel_587:)
				(gEgo sel_253: 180 sel_312: MoveFwd 80 self)
			)
			(1
				(global2 sel_399: (global2 sel_411?))
			)
		)
	)
)

(instance sEnterSouth of Script
	(properties
		sel_20 {sEnterSouth}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_1: 120 sel_0: 270)
				(= sel_136 1)
			)
			(1
				(gEgo sel_253: 0 sel_312: MoveFwd 100 self)
			)
			(2
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sWaterPrompt of Script
	(properties
		sel_20 {sWaterPrompt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_137 3))
			(1
				(gLb2Messager sel_295: 32 0 0 0 self)
			)
			(2 (self sel_111:))
		)
	)
)

(instance sEnterFromTunnel of Script
	(properties
		sel_20 {sEnterFromTunnel}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_312: PolyPath 58 144 self)
			)
			(1
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sClimbUpVat of Script
	(properties
		sel_20 {sClimbUpVat}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= gEgoSel_4_2 -1)
				(= gEgoSel_4 -1)
				(gEgo
					sel_2: 612
					sel_155: sel_141
					sel_156: 0
					sel_328: footstepCode
					sel_104: [local30 global129]
					sel_105:
						[local30 (if (> (gEgo sel_1?) 180)
							(= sel_141 1)
						else
							(= sel_141 0)
						)]
					sel_320:
					sel_161: End self
				)
			)
			(1
				(gEgo
					sel_155: (+ sel_141 2)
					sel_156: 0
					sel_161: Fwd
					sel_312:
						MoveTo
						(gEgo sel_1?)
						(- (gEgo sel_0?) [local45 global129])
						self
				)
			)
			(2
				(gEgo sel_312: 0 sel_328: 0)
				(global2 sel_399: 620)
				(self sel_111:)
			)
		)
	)
)

(instance footstepCode of Code
	(properties
		sel_20 {footstepCode}
	)
	
	(method (sel_57)
		(cond 
			((> (gEgo sel_3?) 1)
				(if
					(and
						(or (== (gEgo sel_4?) 1) (== (gEgo sel_4?) 4))
						(!= gEgoSel_4 (gEgo sel_4?))
					)
					(sFX sel_39:)
					(= gEgoSel_4 (gEgo sel_4?))
				)
			)
			(
				(and
					(or
						(== (gEgo sel_4?) 4)
						(== (gEgo sel_4?) 7)
						(== (gEgo sel_4?) 11)
					)
					(!= gEgoSel_4_2 (gEgo sel_4?))
				)
				(sFX sel_39:)
				(= gEgoSel_4_2 (gEgo sel_4?))
			)
		)
	)
)

(instance sClimbDownVat of Script
	(properties
		sel_20 {sClimbDownVat}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gEgo
					sel_2: 612
					sel_155: (+ sel_141 2)
					sel_156: (gEgo sel_246:)
					sel_153:
						[local0 global129]
						(-
							[local15 (if (> [local0 global129] 180)
								(= sel_141 1)
							else
								(= sel_141 0)
							)]
							[local45 (gGame sel_587:)]
						)
					sel_328: footstepCode
					sel_104: [local30 global129]
					sel_105: [local30 global129]
					sel_320:
					sel_161: Rev
					sel_312: MoveTo [local0 global129] [local15 global129] self
				)
			)
			(1
				(gEgo sel_155: sel_141 sel_156: 13 sel_161: Beg self)
			)
			(2
				(gEgo
					sel_585: 831
					sel_328: 0
					sel_3: (if sel_141 0 else 1)
					sel_320: Scaler 123 0 190 88
				)
				(= sel_136 1)
			)
			(3
				(if (proc0_2 21)
					(gLb2Messager sel_295: 27 0 2)
				else
					(gLb2Messager sel_295: 27 0 1)
				)
				(gGame sel_588:)
				(self sel_111:)
			)
		)
	)
)

(instance sKickOut of Script
	(properties
		sel_20 {sKickOut}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gLb2Messager sel_295: 28 0 5)
				(= sel_136 1)
			)
			(1
				(gGame sel_588:)
				(kickTimer sel_162: kickTimer 7)
				(self sel_111:)
			)
		)
	)
)

(instance sKickOut2 of Script
	(properties
		sel_20 {sKickOut2}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gIconBar sel_177: 7)
				(gGame sel_587:)
				(gLb2Messager sel_295: 28 0 6)
				(= sel_136 1)
			)
			(1
				(gEgo sel_312: PolyPath 108 252 self)
			)
			(2
				(global2 sel_399: (global2 sel_411?))
				(self sel_111:)
			)
		)
	)
)

(instance sDumpIt of Script
	(properties
		sel_20 {sDumpIt}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo sel_2: 611 sel_155: 3 sel_156: 0 sel_161: End self)
			)
			(1 (= sel_139 20))
			(2 (gEgo sel_161: Beg self))
			(3
				(gEgo sel_585: 831 sel_3: 0)
				(= sel_136 1)
			)
			(4
				(gLb2Messager sel_295: 3 25 14 0 self)
			)
			(5
				(gGame sel_588:)
				(= global150 0)
				((gInv sel_64: 14) sel_4: 1)
				(= local63 1)
				(self sel_111:)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		sel_20 {northDoor}
		sel_1 187
		sel_0 120
		sel_213 1
		sel_303 189
		sel_304 125
		sel_2 611
		sel_60 8
		sel_14 16
		sel_589 630
		sel_597 184
		sel_598 118
		sel_599 0
		sel_600 0
	)
	
	(method (sel_606)
		(super sel_606: 173 122 173 117 189 117 189 122 172 122)
	)
)

(instance eastDoor of Door
	(properties
		sel_20 {eastDoor}
		sel_1 306
		sel_0 149
		sel_213 2
		sel_303 311
		sel_304 155
		sel_2 611
		sel_3 1
		sel_60 10
		sel_14 16
		sel_589 640
		sel_593 38
		sel_597 315
		sel_598 147
		sel_599 0
		sel_600 0
	)
	
	(method (sel_110)
		(super sel_110:)
		(self sel_311: 4 38)
	)
	
	(method (sel_605)
		(if
			(or
				(proc0_2 154)
				(proc0_2 4)
				(and
					(== global123 3)
					(proc0_10 -20222)
					(not (proc0_10 4880))
				)
			)
			(super sel_605:)
		else
			(gLb2Messager sel_295: 2 38 4)
			(gGame sel_87: 1 154)
		)
	)
	
	(method (sel_606)
		(super sel_606: 311 150 318 152 318 156 310 153)
	)
)

(instance kickTimer of Timer
	(properties
		sel_20 {kickTimer}
	)
	
	(method (sel_145)
		(if (not (global2 sel_142?))
			(global2 sel_146: sKickOut2)
		)
	)
)

(instance oilJar of View
	(properties
		sel_20 {oilJar}
		sel_1 25
		sel_0 165
		sel_82 11
		sel_213 31
		sel_303 68
		sel_304 181
		sel_2 611
		sel_3 2
		sel_60 15
		sel_14 16400
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(cond 
					((proc0_2 105) (gLb2Messager sel_295: 31 1 10))
					((proc0_2 106) (gLb2Messager sel_295: 31 1 9))
					((proc0_2 107) (gLb2Messager sel_295: 31 1 8))
					(else (gLb2Messager sel_295: 31 1 7))
				)
			)
			(8
				(if (gEgo sel_238: 14)
					(if (proc0_2 105)
						(gLb2Messager sel_295: 31 8 10)
					else
						(gLb2Messager sel_295: 31 8 11)
					)
				else
					(gLb2Messager sel_295: 31 8 12)
				)
			)
			(4
				(if (proc0_2 105)
					(gLb2Messager sel_295: 31 4 10)
				else
					(gLb2Messager sel_295: 31 4 17)
				)
			)
			(25
				(cond
					((== global150 4)
						(gLb2Messager sel_295: 33 1 9 0 0 15)
					)
					((proc0_2 105)
						(gLb2Messager sel_295: 31 1 10)
					)
					(else
						(= global150 4)
						((gInv sel_64: 14) sel_4: 0)
						(cond
							((proc0_2 106)
								(proc0_4 106)
								(proc0_3 105)
								(self sel_156: 3)
							)
							((proc0_2 107)
								(proc0_4 107)
								(proc0_3 106)
								(self sel_156: 2)
							)
							(else
								(proc0_3 107)
								(self sel_156: 1)
							)
						)
						(gLb2Messager sel_295: 33 1 9 0 0 15)
					)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance sink of Feature
	(properties
		sel_20 {sink}
		sel_1 180
		sel_0 167
		sel_213 3
		sel_6 157
		sel_7 162
		sel_8 189
		sel_9 319
		sel_301 40
		sel_302 2
		sel_303 161
		sel_304 184
	)
	
	(method (sel_300 param1)
		(switch param1
			(1
				(if local63
					(gLb2Messager sel_295: 3 1 13)
				else
					(gLb2Messager sel_295: 3 1)
				)
			)
			(8
				(if local63
					(gLb2Messager sel_295: 3 8 13)
				else
					(gLb2Messager sel_295: 3 8)
				)
			)
			(25
				(if global150
					(global2 sel_146: sDumpIt)
				else
					(gLb2Messager sel_295: 3 25 15)
				)
			)
			(4
				(if local63
					(gLb2Messager sel_295: 3 4 13)
				else
					(gLb2Messager sel_295: 3 4)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat1 of Feature
	(properties
		sel_20 {vat1}
		sel_1 206
		sel_0 102
		sel_213 4
		sel_6 75
		sel_7 204
		sel_8 130
		sel_9 208
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 1)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat2 of Feature
	(properties
		sel_20 {vat2}
		sel_1 213
		sel_0 101
		sel_213 5
		sel_6 71
		sel_7 210
		sel_8 132
		sel_9 216
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 2)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat3 of Feature
	(properties
		sel_20 {vat3}
		sel_1 221
		sel_0 102
		sel_213 6
		sel_6 66
		sel_7 217
		sel_8 138
		sel_9 225
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 3)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat4 of Feature
	(properties
		sel_20 {vat4}
		sel_1 230
		sel_0 100
		sel_213 7
		sel_6 56
		sel_7 225
		sel_8 145
		sel_9 236
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 4)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat5 of Feature
	(properties
		sel_20 {vat5}
		sel_1 266
		sel_0 100
		sel_213 8
		sel_6 44
		sel_7 237
		sel_8 156
		sel_9 295
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 5)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat6 of Feature
	(properties
		sel_20 {vat6}
		sel_1 161
		sel_0 102
		sel_213 9
		sel_6 78
		sel_7 159
		sel_8 126
		sel_9 163
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 6)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat7 of Feature
	(properties
		sel_20 {vat7}
		sel_1 155
		sel_0 102
		sel_213 10
		sel_6 74
		sel_7 152
		sel_8 130
		sel_9 159
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 7)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat8 of Feature
	(properties
		sel_20 {vat8}
		sel_1 146
		sel_0 100
		sel_213 11
		sel_6 66
		sel_7 141
		sel_8 135
		sel_9 152
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 8)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat9 of Feature
	(properties
		sel_20 {vat9}
		sel_1 134
		sel_0 99
		sel_213 12
		sel_6 57
		sel_7 128
		sel_8 142
		sel_9 140
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 9)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat10 of Feature
	(properties
		sel_20 {vat10}
		sel_1 98
		sel_0 99
		sel_213 13
		sel_6 44
		sel_7 72
		sel_8 154
		sel_9 125
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 10)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat11 of Feature
	(properties
		sel_20 {vat11}
		sel_1 65
		sel_0 100
		sel_213 14
		sel_6 67
		sel_7 59
		sel_8 133
		sel_9 71
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 11)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat12 of Feature
	(properties
		sel_20 {vat12}
		sel_1 50
		sel_0 100
		sel_213 15
		sel_6 64
		sel_7 42
		sel_8 136
		sel_9 58
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 12)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat13 of Feature
	(properties
		sel_20 {vat13}
		sel_1 31
		sel_0 100
		sel_213 16
		sel_6 59
		sel_7 20
		sel_8 141
		sel_9 42
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 13)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance vat14 of Feature
	(properties
		sel_20 {vat14}
		sel_1 9
		sel_0 92
		sel_213 17
		sel_6 51
		sel_8 133
		sel_9 19
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(4
				(= global129 14)
				(global2 sel_146: sClimbUpVat)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance desk of Feature
	(properties
		sel_20 {desk}
		sel_1 27
		sel_0 161
		sel_213 18
		sel_6 134
		sel_8 189
		sel_9 54
		sel_301 40
		sel_302 4
		sel_303 78
		sel_304 183
	)
	
	(method (sel_300 param1)
		(switch param1
			(25
				(if global150
					(gLb2Messager sel_295: 18 25 14)
					(-- global150)
					((gInv sel_64: 14) sel_4: (if global150 0 else 1))
				else
					(gLb2Messager sel_295: 18 25 15)
				)
			)
			(6
				(gLb2Messager sel_295: 18 6 3)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance drain of Feature
	(properties
		sel_20 {drain}
		sel_1 110
		sel_0 172
		sel_213 19
		sel_6 169
		sel_7 98
		sel_8 176
		sel_9 122
		sel_301 40
	)
	
	(method (sel_300 param1)
		(switch param1
			(25
				(if global150
					(gLb2Messager sel_295: 19 25 14)
					(-- global150)
					((gInv sel_64: 14) sel_4: (if global150 0 else 1))
				else
					(gLb2Messager sel_295: 19 25 15)
				)
			)
			(else  (super sel_300: param1))
		)
	)
)

(instance light of Feature
	(properties
		sel_20 {light}
		sel_1 38
		sel_0 195
		sel_82 100
		sel_213 20
		sel_6 90
		sel_7 29
		sel_8 100
		sel_9 48
		sel_301 40
		sel_302 8
	)
)

(instance funnel of Feature
	(properties
		sel_20 {funnel}
		sel_1 208
		sel_0 150
		sel_213 21
		sel_6 145
		sel_7 201
		sel_8 155
		sel_9 216
		sel_301 40
	)
)

(instance longPipe of Feature
	(properties
		sel_20 {longPipe}
		sel_1 159
		sel_0 31
		sel_213 22
		sel_6 29
		sel_8 33
		sel_9 319
		sel_301 40
	)
)

(instance shortPipe of Feature
	(properties
		sel_20 {shortPipe}
		sel_1 263
		sel_0 17
		sel_213 23
		sel_6 15
		sel_7 208
		sel_8 20
		sel_9 319
		sel_301 40
	)
)

(instance southExit of ExitFeature
	(properties
		sel_20 {southExit}
		sel_6 185
		sel_7 52
		sel_8 189
		sel_9 159
		sel_33 11
		sel_583 3
		sel_213 30
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
		sel_40 613
	)
)

(instance sHeimlichMusic of Sound
	(properties
		sel_20 {sHeimlichMusic}
		sel_99 1
		sel_40 19
		sel_3 -1
	)
)
