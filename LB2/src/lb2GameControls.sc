;;; Sierra Script 1.0 - (do not remove this comment)
(script# 24)
(include sci.sh)
(use Main)
(use Slider)
(use IconI)
(use GameControls)
(use SysWindow)

(public
	lb2GameControls 0
	gcWin 1
)

(instance lb2GameControls of GameControls
	(properties
		sel_20 {lb2GameControls}
	)
	
	(method (sel_110)
		(= gGameControls self)
		(self
			sel_118:
				iconOk
				detailSlider
				(volumeSlider sel_348: gGame sel_519: 404 sel_117:)
				(speedSlider sel_348: gEgo sel_519: 352 sel_117:)
				textSlider
				(iconSave sel_348: gGame sel_519: 75 sel_117:)
				(iconRestore sel_348: gGame sel_519: 76 sel_117:)
				(iconRestart sel_348: gGame sel_519: 101 sel_117:)
				(iconQuit sel_348: gGame sel_519: 100 sel_117:)
				(iconAbout sel_348: gGame sel_519: 613 sel_117:)
				iconHelp
			sel_119: 211 global169
			sel_119: 212 global151
			sel_227: iconHelp
			sel_207: iconSave
			sel_29: 2048
			sel_32: gcWin
		)
		(super sel_110: &rest)
	)
	
	(method (sel_111)
		(super sel_111:)
		(gGame sel_197: gWalkCursor)
		(DisposeScript 934)
		(DisposeScript 978)
		(DisposeScript 24)
	)
	
	(method (sel_216)
		(gGame sel_197: 999)
		(super sel_216: &rest)
	)
)

(instance gcWin of SysWindow
	(properties
		sel_20 {gcWin}
	)
	
	(method (sel_189 &tmp temp0 [temp1 4] temp5 [temp6 20])
		(= sel_31 128)
		(= sel_193 (/ (- 200 (+ (CelHigh 995 1 1) 6)) 2))
		(= sel_194 (/ (- 320 (+ 191 (CelWide 995 0 1))) 2))
		(= sel_195
			(+
				(CelHigh 995 1 1)
				6
				(/ (- 200 (+ (CelHigh 995 1 1) 6)) 2)
			)
		)
		(= sel_196
			(+
				191
				(CelWide 995 0 1)
				(/ (- 320 (+ 191 (CelWide 995 0 1))) 2)
			)
		)
		(= sel_11 (- sel_194 6))
		(= sel_10 (- sel_193 6))
		(= sel_13 (+ sel_196 6))
		(= sel_12 (+ sel_195 6))
		(= sel_60 15)
		(super sel_189:)
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph
			grFILL_BOX
			sel_193
			sel_194
			sel_195
			sel_196
			3
			global151
			15
		)
		(Graph grDRAW_LINE 33 49 33 269 global171 15)
		(Graph grDRAW_LINE 34 50 34 268 gSel_212 15)
		(Graph grDRAW_LINE 35 51 35 267 global170 15)
		(Graph grDRAW_LINE 33 49 166 49 global171 15)
		(Graph grDRAW_LINE 34 50 165 50 gSel_212 15)
		(Graph grDRAW_LINE 35 51 164 51 global170 15)
		(Graph grDRAW_LINE 166 49 166 269 global171 15)
		(Graph grDRAW_LINE 165 50 165 268 gSel_212 15)
		(Graph grDRAW_LINE 164 51 164 267 global170 15)
		(Graph grDRAW_LINE 33 269 166 269 global171 15)
		(Graph grDRAW_LINE 34 268 165 268 gSel_212 15)
		(Graph grDRAW_LINE 35 267 164 267 global170 15)
		(DrawCel 995 0 6 155 (proc0_11 42 45 45 45 45) temp5)
		(DrawCel 995 1 1 56 39 temp5)
		(DrawCel 995 1 0 146 73 temp5)
		(DrawCel 995 1 0 186 73 temp5)
		(DrawCel 995 1 0 226 73 temp5)
		(DrawCel 995 0 4 116 (proc0_11 58 60 60 60 60) temp5)
		(DrawCel
			995
			0
			3
			(proc0_11 145 154 154 154 154)
			(proc0_11 134 60 60 60 60)
			temp5
		)
		(DrawCel
			995
			0
			2
			(proc0_11 178 198 198 198 198)
			(proc0_11 58 60 60 60 60)
			temp5
		)
		(DrawCel 995 0 5 238 (proc0_11 134 60 60 60 60) temp5)
		(Graph grUPDATE_BOX sel_10 sel_11 sel_12 sel_13 1)
		(SetPort temp0)
	)
)

(instance detailSlider of Slider
	(properties
		sel_20 {detailSlider}
		sel_2 995
		sel_3 0
		sel_4 1
		sel_7 67
		sel_6 35
		sel_14 128
		sel_213 1
		sel_214 24
		sel_215 12
		sel_511 995
		sel_520 1
		sel_521 5
	)
	
	(method (sel_57 param1)
		(if argc (gGame sel_321: param1))
		(gGame sel_321:)
	)
)

(instance volumeSlider of Slider
	(properties
		sel_20 {volumeSlider}
		sel_2 995
		sel_3 0
		sel_4 1
		sel_7 107
		sel_6 35
		sel_14 128
		sel_213 2
		sel_214 24
		sel_215 12
		sel_511 995
		sel_521 15
	)
)

(instance speedSlider of Slider
	(properties
		sel_20 {speedSlider}
		sel_2 995
		sel_3 0
		sel_4 1
		sel_7 147
		sel_6 35
		sel_14 128
		sel_213 3
		sel_214 24
		sel_215 12
		sel_511 995
		sel_520 15
	)
	
	(method (sel_57 param1)
		(if argc (gEgo sel_352: param1) (= global3 param1))
		(gEgo sel_53?)
	)
	
	(method (sel_216)
		(if (not (gUser sel_343?))
			(= sel_14 132)
			(= sel_512 9)
		else
			(= sel_512 0)
			(= sel_14 128)
		)
		(super sel_216: &rest)
	)
	
	(method (sel_219)
	)
	
	(method (sel_181)
		(if (gUser sel_343?) (super sel_181: &rest))
	)
)

(instance textSlider of Slider
	(properties
		sel_20 {textSlider}
		sel_2 995
		sel_3 0
		sel_4 1
		sel_7 187
		sel_6 35
		sel_14 128
		sel_213 4
		sel_214 24
		sel_215 12
		sel_511 995
		sel_520 24
		sel_521 1
	)
	
	(method (sel_57 param1)
		(if argc (= global94 param1))
		(return global94)
	)
)

(instance iconSave of ControlIcon
	(properties
		sel_20 {iconSave}
		sel_2 995
		sel_3 2
		sel_4 0
		sel_7 8
		sel_6 8
		sel_37 8
		sel_14 451
		sel_213 5
		sel_214 24
		sel_215 12
	)
)

(instance iconRestore of ControlIcon
	(properties
		sel_20 {iconRestore}
		sel_2 995
		sel_3 3
		sel_4 0
		sel_7 8
		sel_6 28
		sel_37 8
		sel_14 451
		sel_213 6
		sel_214 24
		sel_215 12
	)
)

(instance iconRestart of ControlIcon
	(properties
		sel_20 {iconRestart}
		sel_2 995
		sel_3 4
		sel_4 0
		sel_7 8
		sel_6 48
		sel_37 8
		sel_14 451
		sel_213 7
		sel_214 24
		sel_215 12
	)
)

(instance iconQuit of ControlIcon
	(properties
		sel_20 {iconQuit}
		sel_2 995
		sel_3 5
		sel_4 0
		sel_7 8
		sel_6 68
		sel_37 8
		sel_14 451
		sel_213 8
		sel_214 24
		sel_215 12
	)
)

(instance iconAbout of ControlIcon
	(properties
		sel_20 {iconAbout}
		sel_2 995
		sel_3 6
		sel_4 0
		sel_7 8
		sel_6 88
		sel_37 8
		sel_14 451
		sel_213 9
		sel_214 24
		sel_215 12
	)
)

(instance iconHelp of IconI
	(properties
		sel_20 {iconHelp}
		sel_2 995
		sel_3 7
		sel_4 0
		sel_7 34
		sel_6 88
		sel_33 9
		sel_37 12
		sel_14 387
		sel_213 10
		sel_214 24
		sel_215 12
	)
)

(instance iconOk of IconI
	(properties
		sel_20 {iconOk}
		sel_2 995
		sel_3 8
		sel_4 0
		sel_7 8
		sel_6 108
		sel_33 9
		sel_37 8
		sel_14 451
		sel_213 11
		sel_214 24
		sel_215 12
	)
)
