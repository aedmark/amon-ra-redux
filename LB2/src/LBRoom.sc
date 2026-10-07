;;; Sierra Script 1.0 - (do not remove this comment)
(script# 17)
(include sci.sh)
(use Main)
(use PolyPath)
(use Game)
(use User)
(use Obj)

(public
	eRS 0
)

(procedure (localproc_0390)
	(cond 
		((< (gEgo sel_1?) 0) (gEgo sel_1: (+ 0 (* (gEgo sel_51?) 2))))
		((> (gEgo sel_1?) 319) (gEgo sel_1: (- 319 (* (gEgo sel_51?) 2))))
	)
)

(procedure (localproc_03d6)
	(cond 
		((< (gEgo sel_0?) (global2 sel_340?))
			(gEgo
				sel_0: (+ (global2 sel_340?) (* (gEgo sel_52?) 2))
			)
		)
		((> (gEgo sel_0?) 189) (gEgo sel_0: (- 189 (* (gEgo sel_52?) 2))))
	)
)

(class LBRoom of Rm
	(properties
		sel_20 {LBRoom}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
		sel_408 0
		sel_28 -1
		sel_340 15
		sel_343 0
		sel_409 0
		sel_410 0
		sel_411 0
		sel_412 0
		sel_405 0
		sel_413 0
		sel_107 160
		sel_108 0
		sel_259 0
		sel_365 0
	)
	
	(method (sel_110 param1 &tmp temp0 temp1 [temp2 2])
		(= sel_40 gSel_40)
		(= gSel_413 sel_413)
		(if sel_408 (self sel_417: sel_408))
		(cond 
			((not (gSel_561 sel_122: gEgo)) 0)
			(sel_142 0)
			((not ((User sel_341?) sel_349?)) 0)
			((proc999_5 sel_28 11 12 13 14)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User sel_341?) sel_2?)
								((User sel_341?) sel_3?)
								((User sel_341?) sel_4?)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(/
							(CelHigh
								((User sel_341?) sel_2?)
								((User sel_341?) sel_3?)
								((User sel_341?) sel_4?)
							)
							2
						)
					)
				)
				(switch ((User sel_341?) sel_349?)
					(1
						((User sel_341?) sel_0: 188)
					)
					(4
						((User sel_341?) sel_1: (- 319 temp0))
					)
					(3
						((User sel_341?) sel_0: (+ sel_340 temp1))
					)
					(2
						((User sel_341?) sel_1: (+ 0 temp0))
					)
				)
				((User sel_341?) sel_349: 0)
			)
			(else
				(if (not argc) (= param1 0))
				(self sel_146: eRS param1 gGSel_40)
			)
		)
		(if (gEgo sel_322?) ((gEgo sel_322?) sel_57:))
	)
	
	(method (sel_57 &tmp temp0)
		(cond 
			(sel_142 (sel_142 sel_57:))
			((!= gSel_40 gTheGSel_40) 0)
			((not (gSel_561 sel_122: gEgo)) 0)
			(
				(switch (= temp0 ((User sel_341?) sel_349?))
					(1 sel_409)
					(2 sel_410)
					(3 sel_411)
					(4 sel_412)
				)
				(self sel_146: lRS 0 temp0)
			)
		)
	)
	
	(method (sel_300 param1)
		(if (not (super sel_300: param1))
			(proc0_6 self param1)
		)
	)
	
	(method (sel_422)
		(super sel_422: &rest)
	)
)

(instance lRS of Script
	(properties
		sel_20 {lRS}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(gGame sel_587:)
				(= temp1
					(CelWide (gEgo sel_2?) (gEgo sel_3?) (gEgo sel_4?))
				)
				(= temp0
					(CelHigh (gEgo sel_2?) (gEgo sel_3?) (gEgo sel_4?))
				)
				(switch sel_141
					(1
						(global2 sel_399: (global2 sel_409?))
					)
					(3
						(gEgo
							sel_312: PolyPath (gEgo sel_1?) (+ 189 temp0) self
						)
						(= sel_141 (global2 sel_411?))
					)
					(2
						(gEgo
							sel_312: PolyPath (+ 319 temp1) (gEgo sel_0?) self
						)
						(= sel_141 (global2 sel_410?))
					)
					(4
						(gEgo sel_312: PolyPath (- 0 temp1) (gEgo sel_0?) self)
						(= sel_141 (global2 sel_412?))
					)
				)
			)
			(1
				(gEgo sel_102:)
				(= sel_136 2)
			)
			(2 (global2 sel_399: sel_141))
		)
	)
)

(instance eRS of Script
	(properties
		sel_20 {eRS}
	)
	
	(method (sel_144 theSel_29 &tmp temp0 temp1)
		(switch (= sel_29 theSel_29)
			(0
				(= sel_136 0)
				(if (gUser sel_237:) (gGame sel_587:))
				(= temp0
					(CelHigh (gEgo sel_2?) (gEgo sel_3?) (gEgo sel_4?))
				)
				(= temp1
					(CelWide (gEgo sel_2?) (gEgo sel_3?) (gEgo sel_4?))
				)
				(switch sel_141
					((sel_42 sel_409?)
						(localproc_0390)
						(gEgo sel_0: (+ (global2 sel_340?) (gEgo sel_52?)))
						(= sel_136 1)
					)
					((sel_42 sel_411?)
						(localproc_0390)
						(gEgo
							sel_0: (+ 189 temp0)
							sel_312: PolyPath (gEgo sel_1?) (- 189 (* (gEgo sel_52?) 2)) self
						)
					)
					((sel_42 sel_410?)
						(localproc_03d6)
						(gEgo
							sel_1: (+ 319 (/ temp1 2))
							sel_312: PolyPath (- 319 (* (gEgo sel_51?) 2)) (gEgo sel_0?) self
						)
					)
					((sel_42 sel_412?)
						(localproc_03d6)
						(gEgo
							sel_1: (- 0 (/ temp1 2))
							sel_312: PolyPath (+ 0 (* (gEgo sel_51?) 2)) (gEgo sel_0?) self
						)
					)
					(else  (= sel_136 1))
				)
			)
			(1
				(gGame sel_588: 1)
				(self sel_111:)
			)
		)
	)
)
