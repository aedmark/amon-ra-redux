;;; Sierra Script 1.0 - (do not remove this comment)
(script# 620)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use n958)
(use Sound)
(use Cycle)
(use View)
(use Obj)

(public
	rm620 0
)

(local
	local0
	local1
	local2
)
(procedure (localproc_145d param1)
	(return
		(if (< global129 6)
			(return (- 320 param1))
		else
			(return param1)
		)
	)
)

(instance rm620 of LBRoom
	(properties
		sel_20 {rm620}
		sel_408 620
	)
	
	(method (sel_110)
		(if (gTimers sel_122: (ScriptID 90 15))
			((ScriptID 90 15) sel_42: self)
		)
		(gEgo sel_110: sel_585: 622)
		(proc958_0 128 621 622)
		(proc958_0 132 611 612 615)
		(if (< global129 6) (= sel_28 16384) (= local2 1))
		(super sel_110:)
		(churning
			sel_110:
			sel_155: (+ (churning sel_3?) local2)
			sel_1: (localproc_145d (churning sel_1?))
			sel_161: Fwd
		)
		(self sel_414: 90)
		(switch global129
			(1
				(= local1 8)
				(animal1 sel_110: sel_155: 7 sel_156: 0 sel_153: 130 130)
				(animal2 sel_110: sel_155: 7 sel_156: 1 sel_153: 144 94)
				(animal3 sel_110: sel_155: 7 sel_156: 0 sel_153: 179 105)
				(animal4 sel_110: sel_155: 7 sel_156: 1 sel_153: 169 149)
			)
			(2
				(= local1 10)
				(animal1 sel_110: sel_155: 7 sel_156: 2 sel_153: 129 103)
				(animal2 sel_110: sel_155: 7 sel_156: 3 sel_153: 167 117)
				(animal3 sel_110: sel_155: 7 sel_156: 4 sel_153: 124 134)
				(animal4 sel_110: sel_155: 7 sel_156: 2 sel_153: 126 166)
				(animal5 sel_110: sel_155: 7 sel_156: 4 sel_153: 162 145)
			)
			(3
				(= local1 9)
				(animal1 sel_110: sel_155: 7 sel_156: 5 sel_153: 137 100)
				(animal2 sel_110: sel_155: 7 sel_156: 6 sel_153: 126 134)
				(animal3 sel_110: sel_155: 7 sel_156: 7 sel_153: 178 151)
			)
			(4
				(= local1 6)
				(animal1 sel_110: sel_155: 7 sel_156: 8 sel_153: 149 96)
			)
			(5
				(= local1 6)
				(animal1 sel_110: sel_155: 7 sel_156: 9 sel_153: 125 133)
				(animal2 sel_110: sel_155: 7 sel_156: 10 sel_153: 142 103)
			)
			(6
				(= local1 8)
				(animal1 sel_110: sel_155: 7 sel_156: 13 sel_153: 142 159)
				(animal2 sel_110: sel_155: 7 sel_156: 11 sel_153: 125 116)
				(animal3 sel_110: sel_155: 7 sel_156: 12 sel_153: 173 103)
				(animal4 sel_110: sel_155: 7 sel_156: 12 sel_153: 116 118)
			)
			(7
				(= local1 6)
				(animal1 sel_110: sel_155: 8 sel_156: 0 sel_153: 110 98)
			)
			(8
				(= local1 9)
				(animal1 sel_110: sel_155: 8 sel_156: 3 sel_153: 139 157)
				(animal2 sel_110: sel_155: 8 sel_156: 1 sel_153: 112 102)
				(animal3 sel_110: sel_155: 8 sel_156: 2 sel_153: 164 113)
			)
			(9
				(= local1 10)
				(animal1 sel_110: sel_155: 8 sel_156: 5 sel_153: 114 103)
				(animal2 sel_110: sel_155: 8 sel_156: 6 sel_153: 158 117)
				(animal3 sel_110: sel_155: 8 sel_156: 6 sel_153: 115 141)
				(animal4 sel_110: sel_155: 8 sel_156: 5 sel_153: 129 164)
				(animal5 sel_110: sel_155: 8 sel_156: 5 sel_153: 165 141)
			)
			(10
				(= local1 6)
				(animal1 sel_110: sel_155: 8 sel_156: 7 sel_153: 115 92)
			)
			(11
				(= local1 5)
				(animal1 sel_110: sel_155: 8 sel_156: 8 sel_153: 109 113)
			)
			(12
				(= local1 10)
				(animal1 sel_110: sel_155: 8 sel_156: 9 sel_153: 114 100)
				(animal2 sel_110: sel_155: 8 sel_156: 10 sel_153: 158 117)
				(animal3 sel_110: sel_155: 8 sel_156: 10 sel_153: 109 134)
				(animal4 sel_110: sel_155: 8 sel_156: 10 sel_153: 123 167)
				(animal5 sel_110: sel_155: 8 sel_156: 9 sel_153: 147 145)
			)
			(13
				(= local1 10)
				(animal1 sel_110: sel_155: 0 sel_156: 0 sel_153: 117 125)
				(animal2 sel_110: sel_155: 1 sel_156: 0 sel_153: 134 110)
				(animal3 sel_110: sel_155: 2 sel_156: 0 sel_153: 170 105)
				(animal4 sel_110: sel_155: 3 sel_156: 0 sel_153: 134 148)
				(animal5 sel_110: sel_155: 4 sel_156: 0 sel_153: 173 143)
			)
			(14
				(= local1 6)
				(animal1 sel_110: sel_155: 8 sel_156: 11 sel_153: 163 131)
				(animal2 sel_110: sel_155: 8 sel_156: 12 sel_153: 113 107)
			)
			(else  (= local1 1))
		)
		(self sel_146: sSearchVat)
	)
	
	(method (sel_145)
		((ScriptID 90 15) sel_162: self 10 0 0 global125)
	)
	
	(method (sel_399)
		(if (gTimers sel_122: (ScriptID 90 15))
			(= sel_135 0)
			((ScriptID 90 15) sel_42: (ScriptID 90 15))
		)
		(super sel_399: &rest)
	)
)

(instance sSearchVat of Script
	(properties
		sel_20 {sSearchVat}
	)
	
	(method (sel_57)
		(super sel_57:)
		(switch global129
			(1
				(switch local0
					(0
						(animal1
							sel_1: (Random 129 131)
							sel_0: (Random 128 132)
						)
					)
					(2
						(animal2 sel_1: (Random 143 145) sel_0: (Random 92 96))
					)
					(4
						(animal3
							sel_1: (Random 178 180)
							sel_0: (Random 103 107)
						)
					)
					(6
						(animal4
							sel_1: (Random 168 170)
							sel_0: (Random 147 151)
						)
					)
				)
			)
			(2
				(switch local0
					(0
						(animal1
							sel_1: (Random 128 130)
							sel_0: (Random 101 105)
						)
					)
					(2
						(animal2
							sel_1: (Random 166 168)
							sel_0: (Random 115 119)
						)
					)
					(4
						(animal3
							sel_1: (Random 123 125)
							sel_0: (Random 132 136)
						)
					)
					(6
						(animal4
							sel_1: (Random 125 127)
							sel_0: (Random 164 168)
						)
					)
					(8
						(animal5
							sel_1: (Random 161 163)
							sel_0: (Random 143 147)
						)
					)
				)
			)
			(3
				(switch local0
					(0
						(animal1 sel_1: (Random 136 138) sel_0: (Random 98 102))
					)
					(3
						(animal2
							sel_1: (Random 125 127)
							sel_0: (Random 132 136)
						)
					)
					(6
						(animal3
							sel_1: (Random 177 179)
							sel_0: (Random 149 153)
						)
					)
				)
			)
			(4
				(switch local0
					(0
						(animal1 sel_1: (Random 148 150) sel_0: (Random 94 98))
					)
				)
			)
			(5
				(switch local0
					(0
						(animal1
							sel_1: (Random 124 126)
							sel_0: (Random 131 135)
						)
					)
					(3
						(animal2
							sel_1: (Random 141 143)
							sel_0: (Random 101 105)
						)
					)
				)
			)
			(6
				(switch local0
					(0
						(animal1
							sel_1: (Random 141 143)
							sel_0: (Random 157 161)
						)
					)
					(2
						(animal2
							sel_1: (Random 124 126)
							sel_0: (Random 114 118)
						)
					)
					(4
						(animal3
							sel_1: (Random 172 174)
							sel_0: (Random 101 105)
						)
					)
					(6
						(animal4
							sel_1: (Random 115 117)
							sel_0: (Random 116 120)
						)
					)
				)
			)
			(7
				(switch local0
					(0
						(animal1 sel_1: (Random 109 111) sel_0: (Random 96 100))
					)
				)
			)
			(8
				(switch local0
					(0
						(animal1
							sel_1: (Random 138 140)
							sel_0: (Random 155 159)
						)
					)
					(3
						(animal2
							sel_1: (Random 111 113)
							sel_0: (Random 100 104)
						)
					)
					(6
						(animal3
							sel_1: (Random 163 165)
							sel_0: (Random 111 115)
						)
					)
				)
			)
			(9
				(switch local0
					(0
						(animal1
							sel_1: (Random 113 115)
							sel_0: (Random 101 105)
						)
					)
					(2
						(animal2
							sel_1: (Random 157 159)
							sel_0: (Random 115 119)
						)
					)
					(4
						(animal3
							sel_1: (Random 114 116)
							sel_0: (Random 139 143)
						)
					)
					(6
						(animal4
							sel_1: (Random 128 130)
							sel_0: (Random 162 166)
						)
					)
					(8
						(animal5
							sel_1: (Random 164 166)
							sel_0: (Random 139 143)
						)
					)
				)
			)
			(10
				(switch local0
					(0
						(animal1 sel_1: (Random 114 116) sel_0: (Random 90 94))
					)
				)
			)
			(11
				(switch local0
					(0
						(animal1
							sel_1: (Random 108 110)
							sel_0: (Random 111 115)
						)
					)
				)
			)
			(12
				(switch local0
					(0
						(animal1 sel_1: (Random 113 115) sel_0: (Random 98 102))
					)
					(2
						(animal2
							sel_1: (Random 157 159)
							sel_0: (Random 115 119)
						)
					)
					(4
						(animal3
							sel_1: (Random 108 110)
							sel_0: (Random 132 136)
						)
					)
					(6
						(animal4
							sel_1: (Random 122 124)
							sel_0: (Random 165 169)
						)
					)
					(8
						(animal5
							sel_1: (Random 146 148)
							sel_0: (Random 143 147)
						)
					)
				)
			)
			(13
				(switch local0
					(0
						(animal1
							sel_1: (Random 116 118)
							sel_0: (Random 123 127)
						)
					)
					(2
						(animal2
							sel_1: (Random 133 135)
							sel_0: (Random 108 112)
						)
					)
					(4
						(animal3
							sel_1: (Random 169 171)
							sel_0: (Random 103 107)
						)
					)
					(6
						(animal4
							sel_1: (Random 133 135)
							sel_0: (Random 146 150)
						)
					)
					(8
						(animal5
							sel_1: (Random 172 174)
							sel_0: (Random 141 145)
						)
					)
				)
			)
			(14
				(switch local0
					(0
						(animal1
							sel_1: (Random 162 164)
							sel_0: (Random 129 133)
						)
					)
					(3
						(animal2
							sel_1: (Random 112 114)
							sel_0: (Random 105 109)
						)
					)
				)
			)
		)
		(= local0 (mod (++ local0) local1))
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(gEgo
					sel_155: (- 1 local2)
					sel_156: 0
					sel_153: (localproc_145d 201) 98
					sel_63: 13
					sel_161: End self
				)
			)
			(1
				(gEgo sel_155: (- 3 local2) sel_156: 0 sel_161: End self)
				(sFX sel_40: 611 sel_3: -1 sel_99: 1 sel_39:)
			)
			(2
				(gEgo sel_155: (- 5 local2) sel_156: 0 sel_161: End self)
			)
			(3 (gEgo sel_161: Beg self))
			(4 (= sel_139 45))
			(5 (gEgo sel_161: End self))
			(6
				(sFX sel_167:)
				(if (proc0_2 21)
					(global2 sel_146: sFallInVat)
				else
					(= sel_139 45)
				)
			)
			(7
				(gEgo sel_155: (- 11 local2) sel_156: 0 sel_161: Fwd)
				(net
					sel_110:
					sel_153: (if local2 130 else 183) 35
					sel_155: 12
					sel_312:
						MoveTo
						(if local2 (- (net sel_1?) 53) else (net sel_1?))
						(- (net sel_0?) 90)
						self
				)
				(if
					(and
						(== global129 13)
						(not (proc0_2 22))
						(== global123 3)
					)
					(dagger
						sel_110:
						sel_155: 12
						sel_156: 1
						sel_312: MoveTo (dagger sel_1?) (- (dagger sel_0?) 90)
					)
				)
			)
			(8
				(net sel_313:)
				(dagger sel_313:)
				(gEgo sel_161: 0)
				(= sel_139 60)
			)
			(9
				(if
					(and
						(== global129 13)
						(not (proc0_2 22))
						(== global123 3)
					)
					(global2 sel_146: sFoundDagger)
				else
					(switch global129
						(1
							(gLb2Messager sel_295: 2 0 2)
						)
						(2
							(gLb2Messager sel_295: 3 0 2)
						)
						(3
							(gLb2Messager sel_295: 4 0 2)
						)
						(4
							(gLb2Messager sel_295: 5 0 2)
						)
						(5
							(gLb2Messager sel_295: 6 0 2)
						)
						(6
							(gLb2Messager sel_295: 7 0 2)
						)
						(7
							(gLb2Messager sel_295: 8 0 2)
						)
						(8
							(gLb2Messager sel_295: 9 0 2)
						)
						(9
							(gLb2Messager sel_295: 10 0 2)
						)
						(10
							(gLb2Messager sel_295: 11 0 2)
						)
						(11
							(gLb2Messager sel_295: 12 0 2)
						)
						(12
							(gLb2Messager sel_295: 13 0 2)
						)
						(13
							(if (proc0_2 155)
								(gLb2Messager sel_295: 15 0 7)
							else
								(gLb2Messager sel_295: 15 0 8)
							)
						)
						(14
							(gLb2Messager sel_295: 14 0 2)
						)
					)
					(if (proc0_2 20) (proc0_3 21) else (proc0_3 20))
					(= sel_136 1)
				)
			)
			(10
				(global2 sel_399: 610)
				(self sel_111:)
			)
		)
	)
)

(instance sFoundDagger of Script
	(properties
		sel_20 {sFoundDagger}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gGameMusic2 sel_167:)
				(sFX sel_40: 616 sel_3: -1 sel_99: 1 sel_39:)
				(proc958_0 128 1898 108)
				(gLb2Messager sel_295: 1 0 1 1 self)
			)
			(1
				(gLb2Messager sel_295: 1 0 1 2 self)
			)
			(2
				(gLb2Messager sel_295: 1 0 1 3 self)
			)
			(3
				(gLb2Messager sel_295: 1 0 1 4 self)
			)
			(4
				(gLb2Messager sel_295: 1 0 1 5 self)
			)
			(5
				(gLb2Messager sel_295: 1 0 1 6 self)
			)
			(6
				(gLb2Messager sel_295: 1 0 1 7 self)
			)
			(7
				(sFX sel_40: 615 sel_3: 1 sel_99: 1 sel_39: self)
				(global2 sel_28: 9 sel_417: 785)
				(global2 sel_422: inDagger)
				(= sel_136 10)
			)
			(8
				(gLb2Messager sel_295: 1 0 1 8)
			)
			(9
				(global2 sel_417: (global2 sel_408?))
				(inDagger sel_111:)
				(= sel_136 5)
			)
			(10
				(dagger sel_111:)
				(gEgo sel_350: 11)
				((ScriptID 21 0) sel_57: 780)
				(proc0_3 22)
				(proc0_3 155)
				(gGame sel_87: 1 155)
				((ScriptID 22 0) sel_57: 128)
				(= sel_136 1)
			)
			(11
				(if (proc0_10 8512)
					(global2 sel_399: 26)
				else
					(if (proc0_2 20) (proc0_3 21) else (proc0_3 20))
					(global2 sel_399: 610)
				)
				(self sel_111:)
			)
		)
	)
)

(instance sFallInVat of Script
	(properties
		sel_20 {sFallInVat}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0
				(gLb2Messager sel_295: 1 0 3)
				(= sel_139 45)
			)
			(1
				(gEgo sel_155: (- 7 local2) sel_156: 0 sel_161: End self)
			)
			(2
				(gEgo sel_155: (- 9 local2) sel_156: 0 sel_161: End self)
			)
			(3
				(sFX sel_40: 612 sel_99: 5 sel_39:)
				(gEgo
					sel_63: 10
					sel_161: 0
					sel_312: MoveTo (localproc_145d 181) 142 self
				)
			)
			(4
				(bubbles sel_110: sel_161: End self)
			)
			(5
				(bubbles sel_111:)
				(= sel_139 120)
			)
			(6
				(= global145 5)
				(gGameMusic2 sel_170:)
				(global2 sel_399: 99)
				(self sel_111:)
			)
		)
	)
)

(instance sSparkle of Script
	(properties
		sel_20 {sSparkle}
	)
	
	(method (sel_144 theSel_29)
		(switch (= sel_29 theSel_29)
			(0 (= sel_139 180))
			(1 (spark sel_161: End self))
			(2 (self sel_111:))
		)
	)
)

(instance net of Actor
	(properties
		sel_20 {net}
		sel_1 183
		sel_0 35
		sel_2 622
		sel_3 12
		sel_60 11
		sel_14 24593
		sel_53 3
	)
)

(instance dagger of Actor
	(properties
		sel_20 {dagger}
		sel_1 188
		sel_0 158
		sel_2 622
		sel_3 12
		sel_4 1
		sel_60 11
		sel_14 16401
		sel_53 3
	)
)

(instance churning of Prop
	(properties
		sel_20 {churning}
		sel_1 112
		sel_0 51
		sel_2 621
		sel_3 10
		sel_60 10
		sel_14 16401
		sel_244 12
	)
)

(instance bubbles of Prop
	(properties
		sel_20 {bubbles}
		sel_1 132
		sel_0 60
		sel_2 621
		sel_3 6
		sel_60 11
		sel_14 16401
		sel_244 11
	)
)

(instance spark of Prop
	(properties
		sel_20 {spark}
		sel_1 151
		sel_0 104
		sel_2 108
		sel_60 15
		sel_14 16
	)
)

(instance animal1 of View
	(properties
		sel_20 {animal1}
		sel_2 621
		sel_60 13
		sel_14 16400
	)
)

(instance animal2 of View
	(properties
		sel_20 {animal2}
		sel_2 621
		sel_60 13
		sel_14 16400
	)
)

(instance animal3 of View
	(properties
		sel_20 {animal3}
		sel_2 621
		sel_60 13
		sel_14 16400
	)
)

(instance animal4 of View
	(properties
		sel_20 {animal4}
		sel_2 621
		sel_60 13
		sel_14 16400
	)
)

(instance animal5 of View
	(properties
		sel_20 {animal5}
		sel_2 621
		sel_60 13
		sel_14 16400
	)
)

(instance inDagger of Inset
	(properties
		sel_20 {inDagger}
		sel_2 1898
		sel_3 1
		sel_1 98
		sel_0 3
		sel_560 1
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(spark sel_110:)
		(self sel_146: sSparkle)
	)
)

(instance sFX of Sound
	(properties
		sel_20 {sFX}
		sel_99 1
	)
)
